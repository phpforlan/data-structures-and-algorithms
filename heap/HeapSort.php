<?php
/**
 * @file HeapSort.php
 * @author lurenzhong@xiaomi.com
 * @brief 堆排序
 */

require_once './InitHeap.php';

function heapSort($arr)
{
    $len = count($arr);

    if( $len <= 1 ){
        return $arr;
    }

    for($i=$len; $i>0; $i--){
        InitHeap::init($arr, $i); //第二个参数为初始化的长度

        //将堆顶的最大元素与堆尾进行交换
        $tmp = $arr[$i-1]; //临时存储堆尾元素
        $arr[$i-1] = $arr[0];
        $arr[0] = $tmp;
    }

    return $arr;
}

$arr = [12,45,23,10,24,30,125];
$sortArr = heapSort($arr);
print_r($sortArr);
