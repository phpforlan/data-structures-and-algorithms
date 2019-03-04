package com.imooc.data.structure.queue;

import java.util.Random;

public class TestSpeed {

    public static void main(String[] args) {

        int opCount = 100000;

        //arrayQueue的耗时
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        Double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue consume " + time1 + "s");

        //loopQueue的耗时
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        Double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue consume " + time2 + "s");

    }


    /**
     * 测试队列操作指定次数的耗时(单位:秒)
     *
     * @param queue
     * @param opCount
     * @return
     */
    public static Double testQueue(Queue<Integer> queue, int opCount) {

        long startTime = System.nanoTime();

        //入队
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        //出队
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
