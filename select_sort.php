<?php
/**
 * @file select_sort.php
 * @author lurenzhong@baidu.com
 * @date 16/3/2
 * @brief 选择排序算法
 * @version
 */

/*
基本思想：
    在要排序的一组数中，选出最小的一个数与第1个位置的数交换；然后在剩下的数当中再找最小的与第2个位置的数交换，
    依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
 */


function select_sort($arr){
    $len = count($arr);
    if( $len <= 1 ){ //无需排序
        return $arr;
    }

    for( $i=0; $i<$len; $i++){ //外层循环，当前假设最小值的位置，需要参与比较的元素 0到n-1

        $p = $i; //保存最小值的位置,在下面循环中，$p是动态变化的
        for( $j=$i+1; $j<$len; $j++ ){
            if( $arr[$j] < $arr[$p] ){
                $p = $j;
            }
        }

        //每次把筛选出来的最小值位置，与假设最小值位置进行比较，如果不同，则交换
        if( $p != $i){
            $tmp = $arr[$i];
            $arr[$i] = $arr[$p];
            $arr[$p] = $tmp;
        }

    }



    return $arr;
}

$arr = array(1,333,3,66,9,11,3,111,0);

$sortArr = select_sort($arr);

print_r($sortArr);
