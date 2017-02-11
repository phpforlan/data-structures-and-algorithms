<?php
/**
 * @file partSortTopk.php
 * @author lurenzhong@xiaomi.com
 * @brief 用部分排序的思想，解决topK问题
 */

//部分选择排序，选择k个最大的数
function partSelectSort($arr, $k)
{
    $len = count($arr);
    if($len <= $k){
        echo '数组长度应该大于'.$k. "\n";
    }

    for($i=0; $i<$k; $i++){ //只选择k个最大的数
        for($j=$i+1; $j<$len; $j++){
            if( $arr[$j] > $arr[$i] ){
                $tmp = $arr[$i];
                $arr[$i] = $arr[$j];
                $arr[$j] = $tmp;
            }
        }
    }

    return $arr;
}


//部分冒泡排序,选择k个最大的数
function partBubbleSort($arr, $k)
{
    $len = count($arr);
    if($len <= $k){
        echo '数组长度应该大于'.$k. "\n";
    }

    for($i=1; $i<=$k; $i++){ //比较轮数(这里比较k轮)
        for($j=$len-$i-1; $j>=0; $j--){
            if($arr[$j] < $arr[$j+1]){ //每轮都把最大的数放在最前面
                $tmp = $arr[$j];
                $arr[$j] = $arr[$j+1];
                $arr[$j+1] = $tmp;
            }
        }
    }

    return $arr;
}


//测试
$arr = [1,10,5,30,200,100,300,600,90,12];
$partSortArr = partSelectSort($arr, 3);
print_r($partSortArr);

$partSortArr = partBubbleSort($arr, 3);
print_r($partSortArr);




