package com.imooc.data.structure.LinkedList;

/**
 * 单向链表(有虚拟头结点dummyHead)
 * dummyHead数据为null,默认next为null。size不统计dummyHead，索引从0开始，不包含dummyHead
 */
public class DummyLinkedList<E> {

    //节点定义
    private class Node {

        public E e;
        public Node next;

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
    }

    public Node dummyHead; //虚拟头结点
    public Integer size;

    public DummyLinkedList() {

        dummyHead = new Node();
        size = 0;
    }


}
