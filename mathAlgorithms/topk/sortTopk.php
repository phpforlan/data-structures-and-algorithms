<?php
/**
 * @file sortTopk.php
 * @author lurenzhong@xiaomi.com
 * @brief 用排序思想解决topk问题
 */

//快速排序的时间复杂度是O(nlogn)
function quickSort($arr)
{
    $len = count($arr);

    if( $len <= 1 ){
        return $arr;
    }

    $baseNum = $arr[0];
    $left = [];
    $right = [];
    for($i=1; $i<$len; $i++){ //第一个数不用参与比较了
        if( $arr[$i] < $baseNum ){
            $left[] = $arr[$i];
        }else{
            $right[] = $arr[$i];
        }
    }

    $left = quickSort($left);
    $right = quickSort($right);

    $result = array_merge($left, [$baseNum], $right);

    return $result;
}

$arr = [1,20,2,12,90,6,1,0];
$sortArr = quickSort($arr);

//取出最大的k个数
$k = 5;
$topkArr = array_slice($sortArr, 0, $k);
print_r($topkArr);



