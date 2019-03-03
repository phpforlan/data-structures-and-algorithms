package com.imooc.data.structure.stack;

/**
 * 定义栈的接口
 */
public interface Stack<E> {

    int getSize(); //获取栈当前的大小

    boolean isEmpty();

    void push(E e); //栈顶压入一个元素

    E pop();

    E peek(); //获取栈顶当前元素
}
