package com.imooc.data.structure.stack;

import com.imooc.data.structure.LinkedList.DummyLinkedList;

/**
 * 用链表实现栈
 */
public class LinkedStack<E> implements Stack<E> {

    private DummyLinkedList<E> dummyLinkedList = new DummyLinkedList<>();

    @Override
    public int getSize() {
        return dummyLinkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return dummyLinkedList.isEmpty();
    }

    /**
     * 入栈(链表头部入栈)
     *
     * @param e
     */
    @Override
    public void push(E e) {

        dummyLinkedList.addFirst(e);
    }


    /**
     * 出栈(链表头部出栈)
     *
     * @return
     */
    @Override
    public E pop() {
        return dummyLinkedList.removeFirst();
    }


    /**
     * 获取栈顶当前元素
     *
     * @return
     */
    @Override
    public E peek() {
        return dummyLinkedList.get(0);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("stack: top ");

        for (int i = 0; i < dummyLinkedList.getSize(); i++) {
            E e = dummyLinkedList.get(i);
            res.append(e + "->");
        }

        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();

        for (int i = 0; i < 5; i++) {
            linkedStack.push(i);
        }

        System.out.println(linkedStack);

        linkedStack.pop();
        System.out.println(linkedStack);

        System.out.println(linkedStack.peek());
    }
}
