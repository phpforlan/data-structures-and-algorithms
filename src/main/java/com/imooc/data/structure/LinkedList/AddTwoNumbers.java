package com.imooc.data.structure.LinkedList;

import java.util.LinkedList;

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
public class AddTwoNumbers {

    //节点定义
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 两数之和
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 逆序存储
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        ListNode cur = new ListNode(0);

        while (cur1 != null) {

            while (cur2 != null) { //l1和l2当前节点值都不为空

                int sum = cur1.val + cur2.val;
                cur.val = cur.val + sum % 10;

                cur.next = new ListNode(sum / 10);

                cur = cur.next;

                cur2 = cur2.next;
            }

            cur1 = cur1.next;
        }

        return cur;
    }


    public static void main(String[] args) {

    }
}
