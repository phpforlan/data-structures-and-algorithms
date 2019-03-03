package com.imooc.data.structure.queue;

import com.imooc.data.structure.array.Array;

/**
 * 循环队列(front=tail，则表示队列为空。(tail+1)%c=front，则表示队列满了)
 * <p>
 * tail表示下一个要入队元素放置的位置索引
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front, tail;

    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() { //队列设计会浪费一个空间
        return data.length - 1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
}
