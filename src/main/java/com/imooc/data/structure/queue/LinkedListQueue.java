package com.imooc.data.structure.queue;

import com.imooc.data.structure.LinkedList.LinkedList;

/**
 * 用链表实现队列(链表头部出队，链表尾部入队)
 * 增加尾指针(无dummyHead)
 */
public class LinkedListQueue<E> implements Queue<E> {

    //节点定义
    private class Node {

        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {

            return e.toString();
        }
    }

    private Node head;
    private Node tail; //尾指针
    private Integer size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表尾部入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {

        Node node = new Node(e);

        if (tail == null) { //tail为空，则head也一定为空(设计的原因)
            tail = node;
            head = node;
        } else {

            tail.next = node;
            tail = tail.next;
        }

        size++;
    }

    /**
     * 出队(链表头部出队)
     *
     * @return
     */
    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }

        Node delNode = head;

        //特殊情况，队列中只有一个节点的时候，head和tail指向同一个节点
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            delNode.next = null;
        }

        size--;

        return delNode.e;
    }

    @Override
    public E getFront() {

        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty.");
        }

        return head.e;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("LinkedListQueue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur.e + "->");
            cur = cur.next;
        }

        res.append("NULL tail");

        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        for (int i = 0; i < 5; i++) {
            linkedListQueue.enqueue(i);
        }
        System.out.println(linkedListQueue);

        for (int i = 0; i < 5; i++) {
            linkedListQueue.dequeue();
            System.out.println("dequeue: " + linkedListQueue);
        }


    }
}
