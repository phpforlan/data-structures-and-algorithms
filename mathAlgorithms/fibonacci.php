<?php
/**
 * @file fibonacci.php
 * @author lurenzhong@xiaomi.com
 * @brief 斐波那契数列(1,1,2,3,5,8,13...)
 */

/**
 * @param int $num 要生成的斐波那契数列的长度
 */
function fibonacci($num)
{
    $result = [];

    for($i=0; $i<$num; $i++){

        if( $i==0 || $i==1 ){
            $result[] = 1;
        }else{
            $result[] = $result[$i-1] + $result[$i-2];
        }
    }

    return $result;
}

$result = fibonacci(12);
print_r($result);

