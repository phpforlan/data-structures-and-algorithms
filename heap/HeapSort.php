<?php
/**
 * @file HeapSort.php
 * @author lurenzhong@xiaomi.com
 * @brief php实现堆排序
 */

//引入初始化最大堆类
require_once './InitHeap.php';

function heapSort(&$arr)
{
    $len = count($arr);

    /*
      每次把堆顶(最大值)交换到堆尾,然后对去除堆尾的剩余元素初始化最大堆。重复该步骤
      这样每次最大值就放在堆尾了，完成了排序
     */
    for($i = $len-1; $i>=0; $i--){

        //交换堆顶与堆尾结点
        $tmp = $arr[$i];
        $arr[$i] = $arr[0];
        $arr[0] = $tmp;

        $heapObj = new Heap();
        $heapObj->init($arr, $i);
    }
}

/** 初始化一个最大堆 **/
$arr = [1,8,2,6,3,0,7,5,4];
$heapObj = new Heap();
$heapObj->init($arr, count($arr));

//print_r($arr);

/** 测试堆排序 **/
heapSort($arr);
print_r($arr);
