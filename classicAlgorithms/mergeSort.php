<?php
/**
 * @file mergeSort.php
 * @author lurenzhong@xiaomi.com
 * @brief 归并排序(无序元素的递归分解->有序元素的逐层合并)
 * 时间复杂度为O(nlogn)
 */

/**
 * 功能:合并两个有序数组,合并后依然有序
 */
function merge($left, $right)
{
    $result = []; //保存合并后的结果

    while( count($left) > 0 && count($right) > 0 ){
        //两个最小的数进行比较,并且每次将最小的数放入结果数组中
        if( $left[0] < $right[0] ){ 
            array_push($result, array_shift($left) );
        }else{
            array_push($result, array_shift($right) );
        }
    }

    //while循环后，只剩下一个数组非空了，直接加入到结果数组最后即可
    if( !empty($left) ){
        array_splice($result, count($result), 0, $left);
    }elseif ( !empty($right) ){
        array_splice($result, count($result), 0, $right);
    } 

    return $result;
}

/** 测试merge函数 */
$left = [12,18];
$right = [14,60];
$mergeResult = merge($left, $right);
//print_r($mergeResult);


/**
 * 归并排序函数
 */
function mergeSort($arr)
{
    if( count($arr) <= 1 ){
        return $arr;
    }

    //对数组递归拆分，直到只剩下最后一个元素
    $left = array_slice($arr, 0, (int)count($arr)/2);
    $right = array_slice($arr, (int)count($arr)/2);

    $left = mergeSort($left);
    $right = mergeSort($right);

    $result = merge($left, $right); //合并两个有序数组

    return $result;
}

$arr = [1,23,4,45,12,50,100,25];
$sortArr = mergeSort($arr);
print_r($sortArr);

