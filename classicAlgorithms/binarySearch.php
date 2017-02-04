<?php
/**
 * @file binarySearch.php
 * @author lurenzhong@xiaomi.com
 * @brief 二分查找算法(在有序数组中查找某一特定元素的搜索算法)
 */

/**
 * 时间复杂度是O(logn)
 * @param array $arr 有序数组
 * @param int $search 待查找的数字
 * @return false表示未搜索到结果，否则返回搜索到的值
 */
function binarySearch($arr, $search)
{
    //初始化查找范围的开始位置和结束位置
    $left = 0;
    $right = count($arr) - 1;

    while( $left <= $right ){
        $middle = floor( ($left + $right)/2 ); //搜索范围的中间位置

        //比较大小，调整搜索范围
        if( $search == $arr[$middle] ){
            return $arr[$middle];
        }elseif( $search < $arr[$middle] ){
            $right = $middle - 1;
        }else{
            $left = $middle + 1;
        }
    }

    return false;
}

$arr = [10,12,14,16,18,20];
$searchResult = binarySearch($arr, 18);
var_dump($searchResult);
