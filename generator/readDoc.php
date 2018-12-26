<?php
/**
 * @author lurenzhong@didichuxing.com
 * @date 2018-12-26 15:00
 * @file readDoc.php
 * @brief 利用迭代器读取文本
 * @version
 */

class readDoc
{
    function read()
    {
        $fp = fopen('./school.txt', 'rb');

        while (!feof($fp)) {
            $line = fgets($fp, 2048);
            yield $line;
        }

    }
}

//开始读取文件
$readDocObj = new readDoc();
$generator = $readDocObj->read();

foreach ($generator as $item) {
    echo trim($item) . "\n";
}