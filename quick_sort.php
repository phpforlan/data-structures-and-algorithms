<?php
/**
 * @file quick_sort.php
 * @author lurenzhong@baidu.com
 * @date 16/2/23
 * @brief PHP快速排序算法
 * @version
 */

function quick_sort($arr){

    //判断是否需要排序，不需要直接返回原数组
    if( count($arr) <= 1 ){
        return $arr;
    }

    //确定基准数
    $baseNum = $arr[0];

    $leftArr = array();
    $rightArr = array();
    for( $i=1; $i<count($arr); $i++ ){ //第一个元素为基准数，不参与比较过程
        if( $arr[$i] < $baseNum){
            $leftArr[] = $arr[$i];
        }else{
            $rightArr[] = $arr[$i];
        }
    }

    //这里会一直向下递归执行，直到$leftArr只有一个元素的时候，$rightArr也是。然后从最深处返回式地，依次执行下面的合并过程
    $leftArr = quick_sort($leftArr);
    $rightArr = quick_sort($rightArr);

    //用于调试理解递归调用过程，递归会一直往深处执行，直到$leftArr和$rightArr有返回结果时，执行下面的合并过程
    //printArr($leftArr);
    //printArr($rightArr);
    //echo '<br/>*************<br/>';

    $res = array_merge($leftArr,array($baseNum),$rightArr);//每次合并已排序好的$leftArr、$rightArr，则最终的结果也是已排序的

    return $res;
}


$arr = array(1,3,222,2,12,9,78,0);
$sortArr = quick_sort($arr);

printArr($sortArr);


function printArr($arr){
    echo '<pre>';
    print_r($arr);
    echo '</pre>';
}
