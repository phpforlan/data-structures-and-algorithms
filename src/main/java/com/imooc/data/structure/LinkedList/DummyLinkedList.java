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

        @Override
        public String toString() {

            return e.toString();
        }
    }

    public Node dummyHead; //虚拟头结点
    public Integer size;

    public DummyLinkedList() {

        dummyHead = new Node();
        size = 0;
    }

    public Integer getSize() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }


    /**
     * 向链表指定索引(0-based,不含dummyHead)位置添加节点
     *
     * @param index
     * @param e
     */
    public void add(Integer index, E e) {

        //校验索引是否合法
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index.");
        }

        Node prev = dummyHead; //要插入索引的上一个节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

        size++;
    }


    /**
     * 链表头部添加节点
     */
    public void addFirst(E e) {

        add(0, e);
    }


    /**
     * 链表尾部添加节点
     *
     * @param e
     */
    public void addLast(E e) {

        add(size, e);
    }


    /**
     * 获取链表指定索引的节点数据
     *
     * @param index
     * @return
     */
    public E get(Integer index) {

        //校验索引
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Illegal index.");
        }

        Node cur = dummyHead;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.next;
        }

        return cur.e;
    }


    /**
     * 修改链表指定索引的节点数据
     *
     * @param index
     * @param e
     * @return
     */
    public void set(Integer index, E e) {

        //校验索引
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Illegal index.");
        }

        Node cur = dummyHead;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }


    /**
     * 删除指定索引(0-based，不含dummyHead)的节点
     *
     * @param index
     * @return
     */
    public E remove(Integer index) {

        //校验索引
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Illegal index.");
        }

        Node prev = dummyHead; //要删除节点索引的前一个位置
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node tmp = prev.next.next;
        Node ret = prev.next;
        prev.next = null;
        prev.next = tmp;

        return ret.e;
    }


    /**
     * 删除头部节点
     *
     * @return
     */
    public E removeFirst() {

        return remove(0);
    }


    /**
     * 删除尾部节点
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("DummyLinkedList: ");

        Node cur = dummyHead.next;
        while (cur != null) {

            res.append(cur.e + "->");
            cur = cur.next;
        }

        res.append("NULL");

        return res.toString();
    }


    public static void main(String[] args) {

        DummyLinkedList<Integer> dummyLinkedList = new DummyLinkedList<>();

        for (int i = 0; i < 5; i++) {
            dummyLinkedList.addFirst(i);
        }
        System.out.println(dummyLinkedList);

        dummyLinkedList.add(2, 66);
        System.out.println(dummyLinkedList);

        for (int i = 0; i < 5; i++) {
            dummyLinkedList.addLast(i);
        }
        System.out.println(dummyLinkedList);

        dummyLinkedList.remove(2);
        System.out.println(dummyLinkedList);

        dummyLinkedList.removeFirst();
        System.out.println(dummyLinkedList);
    }

}
