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
     * @param $startPrice string 起始价格
     * @param $batchNum int 购买总批次
     */
    public function run($startPrice, $batchNum)
    {
        //假定第一张购买价格为$startPrice，购买张数为1张
        $arr = [
            [
                'price' => $startPrice,
                'num'   => 1
            ]
        ];

        for ($i = 2; $i <= $batchNum; $i++) {

            //计算当前购买均价
            $averagePrice = $this->calAverage($arr);
            $totalNum = $this->calTotalNum($arr);

            //1.假定价格相对于均价跌了1%，则亏损20%，计算新均价，才能保证只亏损10%
            $marketPrice = round($averagePrice * (1 - 0.01), 2);

            //新均价 $lossRate = ($newAveragePrice - $marketPrice) / $newAveragePrice;
            $lossRate = 0.1 / 20; //新亏损率
            $newAveragePrice = round($marketPrice / (1 - $lossRate), 2);

            //2.如果需要维持新均价，则需要补充多少张 $newAveragePrice = ($needNum * $marketPrice + $averagePrice * $totalNum) / ($needNum + $totalNum);
            $needNum = ($totalNum * ($averagePrice - $newAveragePrice)) / ($newAveragePrice - $marketPrice);
            $needNum = floor($needNum);

            //把最新计算结果赋值给策略数组
            $arr[] = [
                'price' => $marketPrice,
                'num'   => $needNum
            ];

        }

        print_r($arr);

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
        $this->run(79.06, 10);
    }

}


$calBuyObj = new CalBuy();
$calBuyObj->test();