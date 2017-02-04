<?php
/**
 * @file deque.php
 * @author lurenzhong@xiaomi.com
 * @brief 双端队列
 */

class deque
{
    private $queue = [];
    private $length = 0;

    /**
     * 队首添加元素
     */
    public function frontAdd($element)
    {
        array_unshift($this->queue, $element);
        $this->countQueue();
    }

    /**
     * 队首删除元素
     */
    public function frontDel($element)
    {
        array_shift($this->queue, $element);
        $this->countQueue();
    }

    /**
     * 队尾添加元素
     */
    public function rearAdd($element)
    {
        array_push($this->queue, $element);
        $this->countQueue();
    }

    /**
     * 队尾删除元素
     */
    public function rearDel($element)
    {
        array_pop($this->queue, $element);
        $this->countQueue();
    }

    /**
     * 计算队列的长度
     */
    public function countQueue()
    {
        $this->length = count($this->queue);
    }

}

$deque = new deque();
$deque->frontAdd(12);
$deque->frontAdd(18);
$deque->rearAdd(30);
$deque->rearAdd(40);

print_r($deque);

