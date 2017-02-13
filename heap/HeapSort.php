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
    for($i = $len; $i>0; $i--){ //$i是数组要初始化最大堆的长度

        $heapObj = new Heap();
        $heapObj->init($arr, $i);

        //交换堆顶与堆尾结点
        $tmp = $arr[$i-1];
        $arr[$i-1] = $arr[0];
        $arr[0] = $tmp;
    }
}


$arr = [1,8,3,6,0,2,7,4,5];
/** 测试堆排序 **/
heapSort($arr);
print_r($arr);
