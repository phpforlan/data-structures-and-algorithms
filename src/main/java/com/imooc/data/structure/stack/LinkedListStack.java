package com.imooc.data.structure.stack;

import com.imooc.data.structure.LinkedList.DummyLinkedList;

/**
 * 用链表实现栈
 */
public class LinkedListStack<E> implements Stack<E> {

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
        return dummyLinkedList.getFirst();
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

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            linkedListStack.push(i);
        }

        System.out.println(linkedListStack);

        linkedListStack.pop();
        System.out.println(linkedListStack);

        System.out.println(linkedListStack.peek());
    }
}
