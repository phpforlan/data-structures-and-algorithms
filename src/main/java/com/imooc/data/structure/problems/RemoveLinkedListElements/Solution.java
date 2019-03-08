package com.imooc.data.structure.problems.RemoveLinkedListElements;

/**
 * 203. 移除链表元素
 * <p>
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */

//节点定义
class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1); //虚拟头结点
        dummyHead.next = head;

        //开始遍历
        ListNode prev = dummyHead;
        while (prev != null) {

            if (prev.next.val == val) {

                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }

            prev = prev.next;
        }

        return dummyHead.next;
    }


    //1->2->6->3->4->5->6
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        Solution solution = new Solution();
        solution.removeElements(head, 6);

        //输出链表
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
