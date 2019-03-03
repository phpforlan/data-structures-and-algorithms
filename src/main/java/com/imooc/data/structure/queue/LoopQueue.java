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

    private Array<E> array;

    private int front = 0; //队首索引

    private int tail = 0; //队尾索引(队列非空时，为队尾元素后面一个位置)

    public LoopQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public LoopQueue() {
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


    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {

        int tailNext = (tail + 1) % array.getCapacity(); //队尾索引的下一个位置

        //校验队列是否已满
        if (tailNext == front) {
            throw new IllegalArgumentException("queue is full. size:" + array.getSize() + ", capacity:" + array.getCapacity());
        }

        array.add(tail, e);
        tail = tailNext;
    }


    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {

        //校验队列是否为空
        if (front == tail) {
            throw new IllegalArgumentException("queue is empty");
        }

        int tailPrevious;
        if (tail - 1 < 0) {
            tailPrevious = array.getCapacity() - 1;
        } else {
            tailPrevious = (tail - 1);
        }

        tail = tailPrevious;
        return array.remove(tailPrevious);
    }

    @Override
    public E getFront() {
        return array.get(front);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("top queue: [");

        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));

            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }

        res.append("] tail");

        return res.toString();
    }
    
}
