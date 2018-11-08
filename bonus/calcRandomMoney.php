<?php
/**
 * @author lurenzhong@didichuxing.com
 * @date 2018-11-07 22:21
 * @file calcRandomMoney.php
 * @brief 计算随机红包金额
 * @version
 */

class Bonus
{

    private $total; //总金额
    private $min; //单个红包最小金额
    private $max; //单个红包最大金额
    private $num; //红包数量

    public function randomMoney()
    {
        $average = $this->total / $this->num;

        if (mt_rand($this->min, $this->max) > $average) { //如果大于平均金额

        }
    }


    /**
     * 计算$bonusMin到$bonusMax之间的随机数
     * @param $bonusMin
     * @param $bonusMax
     * @return int
     */
    public function xRandom($bonusMin, $bonusMax)
    {
        $sqr = pow($bonusMax - $bonusMin, 2);
        $randNum = mt_rand(0, $sqr - 1);

        return intval(sqrt($randNum));
    }


}

$bonus = new Bonus();
echo $bonus->xRandom(10, 20);