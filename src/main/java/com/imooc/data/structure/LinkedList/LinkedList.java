package com.imooc.data.structure.LinkedList;

/**
 * 单向链表LinkedList实现
 */
public class LinkedList<E> {

    private Node head = null;

    private Integer size = 0; //链表中node节点的数量


    //Node节点定义
    private class Node {

        E e;
        Node next;

        public Node() {
            e = null;
            next = null;
        }

        public Node(E e) {
            this.e = e;
            next = null;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {

            return e.toString();
        }
    }

    /**
     * 链表头部添加节点
     *
     * @param e
     */
    public void addFirst(E e) {

        Node node = new Node(e);
        head = node.next;
        node = head;

        size++;
    }

    /**
     * 在链表指定索引index位置插入节点
     *
     * @param index
     * @param e
     */
    public void add(Integer index, E e) {

        if (index == 0) {
            addFirst(e);
        } else {

            Node pre = head; //index的前一个元素
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }

            Node node = new Node(e);
            pre.next = node.next;
            node = pre.next;
        }

        size++;
    }

    /**
     * 链表尾部添加节点
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }


    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(0);

        System.out.println(linkedList);
    }


}
