<?php
/**
 * @file testInitHeap.php
 * @author lurenzhong@xiaomi.com
 * @brief 测试初始化堆
 */

require_once './InitHeap.php';

$arr = [10,23,3,123,34,9,23];
$initHeap = new InitHeap();
$initHeap->init($arr, count($arr));

print_r($arr);


