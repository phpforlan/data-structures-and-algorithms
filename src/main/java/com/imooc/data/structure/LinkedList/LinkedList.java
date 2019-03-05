package com.imooc.data.structure.LinkedList;

/**
 * 单向链表LinkedList实现
 */
public class LinkedList<E> {

    //Node节点定义
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

        @Override
        public String toString() {

            return e.toString();
        }
    }

    private Node head = null;

    private Integer size = 0; //链表中node节点的数量


    //获取链表中节点的个数
    public int getSize() {
        return size;
    }

    //链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表头部添加节点
     *
     * @param e
     */
    public void addFirst(E e) {

        Node node = new Node(e);
        node.next = head;
        head = node;

        //等同于
        //head = new Node(e, head);

        size++;
    }

    /**
     * 在链表指定索引index(0-based)位置插入节点
     *
     * @param index
     * @param e
     */
    public void add(Integer index, E e) {

        //校验index合法性
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed, Illegal index.");
        }

        if (index == 0) { //要插入位置没有前置节点prev
            addFirst(e);
        } else {

            Node prev = head; //index的前一个元素
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }

            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;

            size++;
        }
    }

    /**
     * 链表尾部添加节点
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("LinkedList head [");

        Node node = head;
        for (int i = 0; i < size; i++) {

            res.append(node);

            node = node.next;

            if (i != size - 1) { //非最后一个节点
                res.append(", ");
            }
        }

        res.append("] tail");

        return res.toString();
    }


    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedList.add(0, i);
        }

        linkedList.add(1, 66);
        linkedList.addLast(100);

        System.out.println(linkedList);
    }


}
