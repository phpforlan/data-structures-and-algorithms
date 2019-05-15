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
     * 计算从当前仓位，根据指定批次挂单的方法，在达到最大亏损率的时候，自动补仓到补仓亏损率的位置(做多的情况)
     * @param $currentAveragePrice string 当前仓位均价
     * @param $currentNum int 当前仓位总张数
     * @param $batchNum int 购买总批次
     * @param $multiple int 开多倍数
     * @param $maxLossRate float 能承受的最大亏损率(取值0-1)
     * @param $supplyLossRate float 补仓亏损率(每次补仓完成后的仓位亏损率,取值0-1)
     * @param $isBtc boolean 是否是比特币(比特币每张价值100美金，非比特币每张价值10美金)
     */
    public function doHigher(
        $currentAveragePrice,
        $currentNum,
        $batchNum,
        $multiple,
        $maxLossRate,
        $supplyLossRate,
        $isBtc
    ) {
        //构造当前仓位数组
        $arr = [
            [
                'price' => $currentAveragePrice,
                'num'   => $currentNum
            ]
        ];

        for ($i = 2; $i <= $batchNum; $i++) {

            //计算当前购买均价
            $averagePrice = $this->calAverage($arr);

            //1.计算当亏损率达到可承受最大亏损率$maxLossRate时的市场价格
            $marketPrice = round($averagePrice * (1 - ($maxLossRate / $multiple)), 2);

            //2.核心:新均价，确保补仓后，亏损不能超过补仓亏损率$supplyLossRate
            $newAveragePrice = round($marketPrice / (1 - $supplyLossRate / $multiple), 2);

            //3.计算如果需要维持新均价，则需要以$marketPrice的价格购买多少张来补仓
            $totalNum = $this->calTotalNum($arr);
            $needNum = ($totalNum * ($averagePrice - $newAveragePrice)) / ($newAveragePrice - $marketPrice);
            $needNum = ceil($needNum);

            //把最新批次结果赋值给仓位数组
            $arr[] = [
                'price' => $marketPrice,
                'num'   => $needNum
            ];
        }

        //计算累计需要购买的总张数
        $finalTotalNum = $this->calTotalNum($arr);

        //计算购买完所有批次后，需要花费的金额(单位:元)
        $finalCostAmount = $finalTotalNum * $this->getSinglePieceRmb($multiple, $isBtc);

        //计算购买完所有批次后的跌幅
        $endPrice = array_slice($arr, count($arr) - 1, 1)[0]['price'];
        $declineRate = round(($currentAveragePrice - $endPrice) / $currentAveragePrice, 4) * 100;


        echo "\n你本次计划购买" . $batchNum . "个批次，所有批次全部购买完毕后，累计购买" . $finalTotalNum . "张，合计人民币" . $finalCostAmount . "元。\n";
        echo "同时，从初始价格【" . $currentAveragePrice . " USDT】到最后购买价格【" . $endPrice . " USDT】" . "，跌幅为:" . $declineRate . "%\n\n";
        echo "所有批次购买计划，见下表:\n\n";

        $this->showTable($arr);
    }


    /**
     * 获取单张合约的价值(单位:元)
     * @param $multiple
     * @param $isBtc
     * @return mixed
     */
    public function getSinglePieceRmb($multiple, $isBtc)
    {
        if ($isBtc) { //btc的情况，10倍时，1张=70元 20倍时，35元

            return $multiple == 10 ? 70 : 35;

        } else { //非btc的情况，10倍时，1张=7元 20倍时，1张=3.5元

            return $multiple == 10 ? 7 : 3.5;
        }
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
        $currentAveragePrice = 211.988; //当前仓位均价
        $currentNum = 15; //当前仓位张数
        $batchNum = 5; //购买总批次
        $multiple = 10; //默认10倍 10/20
        $maxLossRate = 0.2; //能承受的最大亏损率(当亏损率达到该值时，会触发补仓操作。如果发现没有更多资金可补仓，则立刻止损，并发送止损通知)
        $supplyLossRate = 0.12; //补仓亏损率(每次补仓完成后的仓位亏损率)
        $isBtc = false; //是否是比特币

        $this->doHigher($currentAveragePrice, $currentNum, $batchNum, $multiple, $maxLossRate, $supplyLossRate,
            $isBtc); //做多
    }

}

$calBuyObj = new CalBuy();
$calBuyObj->test();