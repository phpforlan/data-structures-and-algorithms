<?php
/**
 * @file InitHeap.php
 * @author lurenzhong@xiaomi.com
 * @brief 初始化一个最大堆
 */

class InitHeap
{
    /**
     * 初始化方法
     * @param array $arr 待初始化数组(index从0开始)
     * @param int $len 需要初始化的长度
     */
    public function init(&$arr, $len)
    {
        $start = floor( $len/2 ) - 1; //最后一个非叶子结点

        for($pNodeIndex = $start; $pNodeIndex >= 0; $pNodeIndex--){
            $this->ajustNode($arr,$pNodeIndex, $len-1);
        }
    }

    /**
     * 调整某个非叶子结点，使其局部符合最大堆的特性
     * @param arrray $arr
     * @param int $pNodeIndex
     * @param int $endIndex 待调整数组最后位置的索引
     */
    public function ajustNode(&$arr, $pNodeIndex, $endIndex)
    {
        //计算左右结点的索引
        $leftNodeIndex = 2*$pNodeIndex + 1;
        $rightNodeIndex = 2*$pNodeIndex + 2;

        $maxIndex = $pNodeIndex;

        //如果左结点比父结点大，则把索引赋值到$maxIndex
        if( $leftNodeIndex <= $endIndex ){
            //备注:与maxIndex索引对应的值进行比较
            if( $arr[$leftNodeIndex] > $arr[$maxIndex] ){ 
                $maxIndex = $leftNodeIndex;
            }
        }

        if( $rightNodeIndex <= $endIndex ){
            if( $arr[$rightNodeIndex] > $arr[$maxIndex] ){
                $maxIndex = $rightNodeIndex;
            }
        }

        //如果最大结点的索引发生变化，则与父结点进行交换
        if( $maxIndex != $pNodeIndex ){
            $tmp = $arr[$pNodeIndex];
            $arr[$pNodeIndex] = $arr[$maxIndex];
            $arr[$maxIndex] = $tmp;

            //与父节点交换的位置发生变化，需要做一次调整
            $this->ajustNode($arr, $maxIndex, $endIndex);
        }

    }

}
