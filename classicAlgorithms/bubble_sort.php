<?php
/**
 * @file bubble_sort.php
 * @author lurenzhong@baidu.com
 * @date 16/3/1
 * @brief 冒泡排序
 * @version
 */

function bubble_sort($arr){
    $len = count($arr);
    if( $len <=1 ){
        return $arr;
    }

    for( $i=1; $i<$len; $i++){ //比较轮数 n-1轮
        for( $j=0; $j<($len-$i); $j++){
            if( $arr[$j] > $arr[$j+1]){ //交换过程
                $tmp = $arr[$j+1];
                $arr[$j+1] = $arr[$j];
                $arr[$j] = $tmp;
            }
        }
    }

    return $arr;
}

$arr = array(111,3,4,55,12,0,34);

$sort_arr = bubble_sort($arr);

print_r($sort_arr);
