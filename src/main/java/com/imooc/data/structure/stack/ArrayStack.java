package com.imooc.data.structure.stack;

import com.imooc.data.structure.array.Array;

/**
 * 借助array类实现stack
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 栈顶取出一个元素并返回
     *
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 获取栈的容量
     *
     * @return
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override //标记此方式是覆盖父类的，便于编辑器检查错误
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Stack: [");

        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }

        res.append("] top");

        return res.toString();
    }

}
