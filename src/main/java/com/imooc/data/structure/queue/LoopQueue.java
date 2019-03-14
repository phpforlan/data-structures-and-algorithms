package com.imooc.data.structure.queue;

/**
 * 通过静态数组实现循环队列(队首出，队尾进)
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail; //下一个入队元素放置的位置
    private int size;

    public LoopQueue() {
        data = (E[]) new Object[11];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    /**
     * 获取队列的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 队首和队尾指针指向同一个位置时，队列为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 元素队尾入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {

        //校验队列是否已满
        if ((tail + 1) % data.length == front) { //有意浪费一个空间

            //自动扩容
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 自动扩容
     *
     * @param newCapacity
     */
    public void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity + 1];

        int j = 0;
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            newData[j] = data[i];
            j++;
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {

        //校验队列是否为空
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty.");
        }

        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;

        size--;

        return e;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("queue front: [");

        int cur = front;
        for (int i = 0; i < size; i++) {
            res.append(data[cur]);

            cur = (cur + 1) % data.length;

            if (i != size - 1) {
                res.append(",");
            }
        }

        res.append("] tail");

        return res.toString();
    }


    public static void main(String[] args) {

        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        for (int i = 0; i < 15; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }

        for (int j = 0; j < 15; j++) {
            loopQueue.dequeue();
            System.out.println(loopQueue);
        }

    }

}
