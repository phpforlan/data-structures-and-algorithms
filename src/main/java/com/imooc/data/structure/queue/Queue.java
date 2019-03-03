package com.imooc.data.structure.queue;

public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e); //入队(队尾)

    E dequeue(); //出队(队首)

    E getFront(); //获取队首的元素

}
