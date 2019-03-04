package com.imooc.data.structure.queue;

import com.imooc.data.structure.array.Array;

/**
 * 循环队列(front=tail，则表示队列为空。(tail+1)%c=front，则表示队列满了)
 * <p>
 * tail表示下一个要入队元素存放的位置索引
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

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {

        //校验队列是否已满
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2); //扩容X2
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }


    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {

        //校验队列是否为空
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }

        E ret = data[front];

        data[front] = null;
        front = (front + 1) % data.length; //front向前移动一位
        size--;

        return ret;
    }


    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        res.append("queue front [");

        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);

            if ((i + 1) % data.length != tail) { //队尾元素
                res.append(", ");
            }
        }

        res.append("] tail");

        return res.toString();
    }


    /**
     * 获取队首元素
     *
     * @return
     */
    @Override
    public E getFront() {
        return data[front];
    }


    /**
     * 队列扩容
     *
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0; i < size; i++) { //从索引0开始填充新data

            newData[i] = data[(i + front) % data.length]; //从i开始偏移front个位置
        }

        data = newData;
        front = 0;
        tail = size;
    }

    public static void main(String[] args) {

        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        //入队
        for (int i = 0; i < 5; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }

        System.out.println("start dequeue...");

        //出队
        for (int i = 0; i < 5; i++) {
            loopQueue.dequeue();
            System.out.println(loopQueue);
        }

        System.out.println(loopQueue.front);
        System.out.println(loopQueue.tail);
        System.out.println(loopQueue.size);

    }
}
