package com.imooc.data.structure.LinkedList;

/**
 * 单向链表实现(无虚拟头节点dummyHead)
 *
 * @param <E>
 */
public class LinkedList<E> {


    //节点Node定义
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

    private Node head; //头节点
    private Integer size; //链表中节点的数量


    public Integer getSize() {
        return size;
    }

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

        size++;
    }


    /**
     * 链表指定索引(0-based)位置添加节点
     *
     * @param index
     * @param e
     */
    public void add(Integer index, E e) {

        //校验索引是否合法
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index.");
        }

        if (index == 0) {
            addFirst(e);
        } else {

            Node prev = head; //要插入索引的前一个位置
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
     * 在链表尾部添加节点
     *
     * @param e
     */
    public void addLast(E e) {

        add(size, e);
    }


    /**
     * 获取链表指定索引节点的数据
     *
     * @param index
     * @return
     */
    public E get(Integer index) {

        //校验索引
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Illegal index.");
        }

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * 获取链表头部节点数据
     *
     * @return
     */
    public E getFirst() {

        return get(0);
    }


    /**
     * 修改指定索引节点的数据
     *
     * @param index
     * @param e
     */
    public void set(Integer index, E e) {

        //校验索引
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Illegal index.");
        }

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }


    /**
     * 删除头结点
     *
     * @return
     */
    public E removeFirst() {

        Node tmp = head.next;
        Node ret = head;
        head = null;
        head = tmp;

        return ret.e;
    }

    /**
     * 删除指定索引(0-based)的节点
     *
     * @param index
     * @return
     */
    public E remove(Integer index) {

        //校验索引
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Illegal index.");
        }

        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        Node tmp = prev.next.next;
        Node ret = prev.next;
        prev.next = null;
        prev.next = tmp;

        return ret.e;
    }

}
