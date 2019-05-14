<?php
/**
 * @author lurenzhong@didichuxing.com
 * @date 2019-05-11 16:02
 * @file calBuy.php
 * @brief
 * @version
 */

class CalBuy
{

    /**
     * 计算从起始价格，根据指定次数挂单的方法(保证亏损不超过10%) 多单的情况
     * @param $currentAveragePrice string 当前仓位均价
     * @param $currentNum int 当前仓位总张数
     * @param $batchNum int 购买总批次
     * @param $multiple int 开多倍数
     * @param $maxLossRate float 能承受的最大亏损率(取值0-1)
     * @param $supplyLossRate float 补仓亏损率(每次补仓完成后的仓位亏损率)
     */
    public function run($currentAveragePrice, $currentNum, $batchNum, $multiple, $maxLossRate, $supplyLossRate)
    {
        //假定第一张购买价格为$startPrice，购买张数为1张
        $arr = [
            [
                'price' => $currentAveragePrice,
                'num'   => $currentNum
            ]
        ];

        for ($i = 2; $i <= $batchNum; $i++) {

            //计算当前购买均价
            $averagePrice = $this->calAverage($arr);
            $totalNum = $this->calTotalNum($arr);

            //1.计算当亏损率达到可承受最大亏损率$maxLossRate时的市场价格
            $marketPrice = round($averagePrice * (1 - ($maxLossRate / $multiple)), 2);

            //2.核心:新均价，确保补仓后，亏损不能超过补仓亏损率$supplyLossRate
            $newAveragePrice = round($marketPrice / (1 - $supplyLossRate / $multiple), 2);

            //3.如果需要维持新均价，则需要补充多少张 $newAveragePrice = ($needNum * $marketPrice + $averagePrice * $totalNum) / ($needNum + $totalNum);
            $needNum = ($totalNum * ($averagePrice - $newAveragePrice)) / ($newAveragePrice - $marketPrice);
            $needNum = ceil($needNum);

            //把最新计算结果赋值给策略数组
            $arr[] = [
                'price' => $marketPrice,
                'num'   => $needNum
            ];
        }

        //计算累计需要购买的总张数
        $finalTotalNum = $this->calTotalNum($arr);
        //计算购买完所有批次后的跌幅
        $endPrice = array_slice($arr, count($arr) - 1, 1)[0]['price'];
        $declineRate = ($currentAveragePrice - $endPrice) / $currentAveragePrice;
        $declineRate = round($declineRate, 4) * 100;

        //todo:这里合计人民币计算是错误的，一张不一定等于5块。(根据倍数不同，价值不同)
        //每张合约的价格 = (仓位总价值 * 倍数) / 10 (如果是比特币，则除以100)
        echo "\n你本次计划购买" . $batchNum . "个批次，所有批次全部购买完毕后，累计购买" . $finalTotalNum . "张，合计人民币" . $finalTotalNum * 5 . "元。\n";
        echo "同时，从初始价格【" . $currentAveragePrice . " USDT】到最后购买价格【" . $endPrice . " USDT】" . "，跌幅为:" . $declineRate . "%\n\n";
        echo "所有批次购买计划，见下表:\n\n";

        $this->showTable($arr);
    }


    /**
     * 获取单张合约的价值(单位:元)
     * @param $multiple
     * @param $isBtc
     */
    public function getSinglePieceRmb($multiple, $isBtc)
    {

    }


    /**
     * 显示购买计划表
     * @param $arr
     */
    public function showTable($arr)
    {
        if (empty($arr)) {
            echo "暂无购买批次购买计划\n";
            exit;
        }

        echo " 购买价格     " . "  购买张数\n";
        foreach ($arr as $item) {
            echo $item['price'] . " USDT     " . $item['num'] . "\n";
        }

    }


    /**
     * 计算均价
     * @param $arr
     * @return mixed
     */
    public function calAverage($arr)
    {
        if (empty($arr)) {
            return 0;
        }

        $totalAmount = 0;
        $totalNum = 0;
        foreach ($arr as $item) {
            $totalAmount += $item['price'] * $item['num'];
            $totalNum += $item['num'];
        }

        return round($totalAmount / $totalNum, 2);
    }


    /**
     * 计算总张数
     * @param $arr
     * @return mixed
     */
    public function calTotalNum($arr)
    {
        if (empty($arr)) {
            return 0;
        }

        $totalNum = 0;
        foreach ($arr as $item) {
            $totalNum += $item['num'];
        }

        return $totalNum;
    }


    /**
     * 测试方法
     */
    public function test()
    {
        $currentAveragePrice = 210; //当前仓位均价
        $currentNum = 1; //当前仓位张数
        $batchNum = 7; //需要购买的批次
        $multiple = 10; //默认10倍 10/20
        $maxLossRate = 0.15; //能承受的最大亏损率(当亏损率达到该值时，会触发补仓操作。如果发现没有更多资金可补仓，则立刻止损，并发送止损通知)
        $supplyLossRate = 0.09; //补仓亏损率(每次补仓完成后的仓位亏损率)

        //500块，能开100张。一张5块钱。
        $this->run($currentAveragePrice, $currentNum, $batchNum, $multiple,
            $maxLossRate, $supplyLossRate); //从初始价格到10次购买后，跌幅达到5%。累计需要1200张，合计6000块。
    }

}

$calBuyObj = new CalBuy();
$calBuyObj->test();