package com.imooc.data.structure.LinkedList;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.List;

/**
 * 2.两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 */

//节点定义
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {

    /**
     * 两数之和
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 逆序存储
     * <p>
     * l1.val+l2.val+carry
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0); //虚拟头结点
        int carry = 0; //商

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        ListNode cur = dummyHead;
        while (cur1 != null || cur2 != null) { //核心公式: l1.val+l2.val+carry

            int x = cur1 == null ? 0 : cur1.val;
            int y = cur2 == null ? 0 : cur2.val;

            int sum = x + y + carry;

            //计算节点值
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            //计算带入下一次计算的商
            carry = sum / 10;

            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }

        if (carry == 1) { //说明还有进位
            cur.next = new ListNode(carry);
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode head = addTwoNumbers.addTwoNumbers(l1, l2);

        //遍历
        StringBuilder res = new StringBuilder();
        res.append("LinkedList: ");

        ListNode cur = head;
        while (cur != null) {

            res.append(cur.val + "->");

            cur = cur.next;
        }

        res.append("NULL");

        System.out.println(res.toString());

    }
}
