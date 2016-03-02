<?php
/**
 * @file insert_sort.php
 * @author lurenzhong@baidu.com
 * @date 16/3/2
 * @brief PHP插入排序算法
 * @version
 */

/*
 插入排序是对已经存在的一个有序的数据序列，在这个已经排好的数据序列中插入一个数，这个时候用插入排序比较好
 */

//从小到大排序
function insert_sort($arr){
    $len = count($arr);
    if( $len <= 1 ){
        return $arr;
    }

    for( $i=1; $i<$len; $i++ ){ //从第2个元素开始  第1个元素被认定为已排序

        //获取当前需要插入的元素
        $insertNum = $arr[$i];

        //从后往前扫描前面已排序数组，在合适位置插入$arr[$i]
        for( $j=$i-1; $j>=0; $j-- ){

            if( $insertNum < $arr[$j] ){ //如果待插入元素$insertNum小于某个元素，则将该元素右移一位，并将$insertNum插入到该元素原位置
                $arr[$j+1] = $arr[$j]; //后移一位
                $arr[$j] = $insertNum;//将$insertNum插入到该元素原位置
            }else{
                break; //由于是已经排序好是数组，如果碰到不需要移动的元素，则前面的就不需要再次比较了。
            }
        }

    }

    return $arr;

}

$arr = array(1,333,4,0,33,1,30,54,9,12);

$sortArr = insert_sort($arr);

print_r($sortArr);
