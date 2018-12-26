<?php
/**
 * @author lurenzhong@didichuxing.com
 * @date 2018-12-26 14:47
 * @file test.php
 * @brief
 * @version
 */

class Test
{
    function createRange($number)
    {
        for ($i = 0; $i < $number; $i++) {
            yield time();
        }
    }
}

$testObj = new Test();
$result = $testObj->createRange(10);

