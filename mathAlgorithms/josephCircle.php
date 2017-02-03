<?php
/**
 * @file josephCircle.php
 * @author lurenzhong@xiaomi.com
 * @brief 约瑟夫环
 */

/**
 * 解决问题:
 * 一群猴子排成一圈，按 1,2,...,n 依次编号。然后从第 1 只开始数，数到第 m 只,把它踢出圈，
 * 从它后面再开始数， 再数到第 m 只，再把它踢出去...，如此不停的进行下去，
 * 直到最后只剩下一只猴子为止，那只猴子就叫做大王。要求编程模拟此过程，输入 m、n, 输出最后那个大王的编号。
 * @param int $m 数到第m只，则踢出去
 * @param int $n 共有n只猴子
 */
function findKingMonkey($n, $m)
{
    $arr = [];

    //创建键值为1-n的数组(模拟猴子围成一圈)
    for($i=1; $i<=$n; $i++){
        $arr[$i] = $i;
    }

    //开始数数,直到数组只剩下一个元素
    while( count($arr) > 1 ){
        for($counter=1; $counter<=$m; $counter++){ //向右数m次
            
            if( next($arr) ){ //指针右移一位，如果下一个元素存在
                if( $counter == $m ){
                    $key = array_search(prev($arr), $arr); //第m次对应的键key
                    unset($arr[$key]); //踢出数组
                }
            }else{
                if( $counter == $m ){
                    $key = array_pop($arr); //将数组最后一个元素剔除
                }
                reset($arr);
            }

        }
    }

    return $arr;
}

$kingMonkey = findKingMonkey(100, 17);
print_r($kingMonkey);

