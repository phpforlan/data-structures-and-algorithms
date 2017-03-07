<?php
/**
 * @file HeapSort.php
 * @author lurenzhong@xiaomi.com
 * @brief 堆排序
 */

require_once './InitHeap.php';

function heapSort(&$arr)
{
    $len = count($arr);

    if( $len <= 1 ){
        return $arr;
    }

    $initHeapObj = new InitHeap();

    for($i=0; $i<$len; $i++){
        $initHeapObj->init($arr, $len-$i);

        //将堆顶与堆尾元素进行交换
        $tmp = $arr[$len-$i-1];
        $arr[$len-$i-1] = $arr[0];
        $arr[0] = $tmp;
    }

}

$arr = [10,23,45,5,22,9,123];
heapSort($arr);

print_r($arr);
