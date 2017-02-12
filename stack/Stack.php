<?php
/**
 * @file Stack.php
 * @author lurenzhong@xiaomi.com
 * @brief php实现栈(后进先出)
 */

class Stack
{
    private $stack = [];

    /**
     * 队尾入栈
     * @param $element
     */
    public function rearAdd($element)
    {
        array_push($this->stack, $element);
    }

    /**
     * 队尾出栈
     */
    public function rearDel()
    {
        array_pop($this->stack);
    }

    /**
     * 获取栈的所有元素
     */
    public function getList()
    {
        return $this->stack;
    }

}

/** 测试栈 **/

$stackObj = new Stack();

//队尾入栈
$stackObj->rearAdd(12);
$stackObj->rearAdd(30);
$stackObj->rearAdd(60);

//队尾出栈
$stackObj->rearDel();

//获取当前栈
$stackList = $stackObj->getList();
print_r($stackList);

