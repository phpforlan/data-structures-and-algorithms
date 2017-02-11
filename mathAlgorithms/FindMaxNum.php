<?php
/**
 * @file FindMaxNum.php
 * @author lurenzhong@xiaomi.com
 * @brief 查找n个数中最大的数( 时间复杂度为O(n) )
 */ 

class MaxNum
{
    /**
     * 查找出最大的那个数
     */
    public static function findTopOne($arr)
    {
        if( empty($arr) || !is_array($arr) ){
            echo '请输入一个非空数组!'. "\n";
        }

        $len = count($arr);

        $maxNum = $arr[0]; //初始最大值为第一个数

        for($i=1; $i<$len; $i++){
            if( $arr[$i] > $maxNum ){
                $maxNum = $arr[$i];
            }
        }

        return $maxNum;
    }

}

$arr = [12,3,10,0,1,45,2,187,23,1000];

//找出最大的那个数
$maxNum = MaxNum::findTopOne($arr);
echo $maxNum. "\n";

