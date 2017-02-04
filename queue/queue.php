<?php
/**
 * @file queue.php
 * @author lurenzhong@xiaomi.com
 * @brief 单向队列(队尾进，队首出)
 */

class queue
{
    private $queue = [];
    private $length = 0;

    /**
     * 队尾进
     */
    public function rearAdd($element)
    {
       array_push($this->queue, $element);
       $this->countLength();
    }

    /**
     * 队首出
     */
    public function frontDel()
    {
        array_shift($this->queue);
        $this->countLength();
    }

    /**
     * 计算队列的长度
     */
    public function countLength()
    {
        $this->length = count($this->queue);
    }

}
