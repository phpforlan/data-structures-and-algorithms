<?php
/**
 * @file InitHeap.php
 * @author lurenzhong@xiaomi.com
 * @brief 初始化一个最大(二叉)堆(特征：父结点的键值总是>=任何一个子结点的键值)
 */

/**
 * 一般用数组来表示堆，i结点的父节点下标为(i-1)/2,它的左右子结点下标分别为2*i+1和2*i+2
 */
class Heap
{
    /**
     * 初始化最大堆-从最后一个非叶子结点开始
     */
    public function init(&$arr)
    {
        $len = count($arr);
        $start = floor($len/2) - 1; //最后一个非叶子结点下标
        
        //从最后一个非叶子结点到根结点，依次调整
        for($pNodeIndex = $start; $pNodeIndex >= 0; $pNodeIndex--){ //非叶子结点也就是父结点
            $this->ajustNode($arr, $pNodeIndex, $len-1);
        }

    }

    /**
     * 调整传入父结点和其左结点、右结点的位置，使其符合最大堆的特征 
     * @param array $arr 待调整数组
     * @param int $pNodeIndex 要调整的父结点下标
     * @param int $endIndex 待调整数组最后一个结点下标
     */
    public function ajustNode(&$arr, $pNodeIndex, $endIndex)
    {
        //计算当前需要调整的父结点的左右结点
        $leftNodeIndex = 2*$pNodeIndex + 1;
        $rightNodeIndex = 2*$pNodeIndex + 2;

        $maxIndex = $pNodeIndex; //默认父结点下标为最大值下标
        if( $leftNodeIndex <= $endIndex ){ //如果该父结点存在左结点,则与父结点比较大小
            if( $arr[$leftNodeIndex] > $arr[$maxIndex] ){
                $maxIndex = $leftNodeIndex;
            }
        }

        if( $rightNodeIndex <= $endIndex ){ //如果该父结点存在右结点,同上
            if( $arr[$rightNodeIndex] > $arr[$maxIndex] ){
                $maxIndex = $rightNodeIndex;
            }
        }

        //如果左结点或右结点大于父结点，则交换位置
        if( $maxIndex != $pNodeIndex ){
            $tmp = $arr[$pNodeIndex];
            $arr[$pNodeIndex] = $arr[$maxIndex];
            $arr[$maxIndex] = $tmp;

            //与父结点交换后，原有值改变了，需要再次调整
            $this->ajustNode($arr, $maxIndex, $endIndex);
        }

    }
}

$arr = [1,5,3,7,9,10,2,8];
$heapObj = new Heap();
$heapObj->init($arr);
//print_r($arr);

