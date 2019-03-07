<?php

/**
 * Class AddTwoNumbers
 * 2.两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *   输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *   输出：7 -> 0 -> 8
 *   原因：342 + 465 = 807
 */

//节点定义
class ListNode
{
    public $val = 0;
    public $next = null;

    function __construct($val)
    {
        $this->val = $val;
    }
}

class AddTwoNumber
{

    /**
     *  * class ListNode {
     *     public $val = 0;
     *     public $next = null;
     *     function __construct($val) { $this->val = $val; }
     * }
     */

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function addTwoNumbers($l1, $l2)
    {
        $dummyHead = new ListNode(0); //虚拟头节点

        $cur1 = $l1;
        $cur2 = $l2;
        $carry = 0; //商(进位)

        $cur = $dummyHead;
        while ($cur1 != null || $cur2 != null) { //核心公式: $l1->val + $l2->val + carry

            $x = $cur1 == null ? 0 : $cur1->val;
            $y = $cur2 == null ? 0 : $cur2->val;

            $sum = $x + $y + $carry;

            //加和结果
            $cur->next = new ListNode($sum % 10);
            $cur = $cur->next;

            //更新进位
            $carry = intval($sum / 10);

            $cur1 = $cur1->next;
            $cur2 = $cur2->next;
        }

        //如果还有进位，则附加到链表尾部
        if ($carry == 1) {
            $cur->next = new ListNode($carry);
        }

        return $dummyHead->next;
    }

    function test()
    {
        //构造数据
        $l1 = new ListNode(2);
        $l1->next = new ListNode(4);
        $l1->next->next = new ListNode(3);

        $l2 = new ListNode(5);
        $l2->next = new ListNode(6);
        $l2->next->next = new ListNode(4);

        $node = $this->addTwoNumbers($l1, $l2);

        //遍历输出链表
        $str = "LinkedList: ";
        while ($node != null) {
            $str = $str . $node->val . "->";
            $node = $node->next;
        }

        $str = $str . "NULL";

        echo $str;
    }
}

$addTwoNumber = new AddTwoNumber();
$addTwoNumber->test();
