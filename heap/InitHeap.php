<?php
/**
 * @file InitHeap.php
 * @author lurenzhong@xiaomi.com
 * @brief 初始化最大堆
 */

class InitHeap
{
    /**
     * 初始化最大堆
     * @param array $arr 待初始化数组
     * @param int $len 需要初始化的长度
     */
    public static function init(&$arr, $len)
    {
        $start = floor( $len/2 ) - 1; //最后一个非叶子结点的索引

        for($pNodeIndex = $start; $pNodeIndex >= 0; $pNodeIndex--){
            self::ajustNode($arr, $pNodeIndex, $len-1);
        }

    }


    /**
     * 调整某个非叶子结点，使其在局部符合最小堆特性
     * @param array $arr 待初始化数组
     * @param int $pNodeIndex 待调整非叶子结点
     * @param int $endIndex 最大索引值
     */
    public static function ajustNode(&$arr, $pNodeIndex, $endIndex)
    {
        $leftNodeIndex = 2*$pNodeIndex + 1; //左结点的索引
        $rightNodeIndex = 2*$pNodeIndex + 2; //右结点的索引

        $maxIndex = $pNodeIndex; //默认最大索引值为待调整结点的索引

        //左结点与父节点比较大小，如果较大，则更新maxIndex
        if( $leftNodeIndex <= $endIndex ){
            if( $arr[$leftNodeIndex] > $arr[$maxIndex] ){
                $maxIndex = $leftNodeIndex;
            }
        }

        if( $rightNodeIndex <= $endIndex ){
            if( $arr[$rightNodeIndex] > $arr[$maxIndex] ){
                $maxIndex = $rightNodeIndex;
            }
        }

        //如果最大索引发生变化，则与父节点交换对应的值
        if( $maxIndex != $pNodeIndex ){
            $tmp = $arr[$pNodeIndex];
            $arr[$pNodeIndex] = $arr[$maxIndex];
            $arr[$maxIndex] = $tmp;

            //因为maxIndex对应值发生变化，需要重新调整
            self::ajustNode($arr, $maxIndex, $endIndex);
        }

    }

}

/** 测试初始化函数 */
//$arr = [12,34,4,190,23,90,12,39,10];
//InitHeap::init($arr, count($arr) );
//print_r($arr);

