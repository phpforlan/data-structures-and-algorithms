package com.imooc.data.structure.stack;

import java.util.Random;

public class TestStackSpeed {

    /**
     * 测试指定栈操作opCount次操作的耗时
     *
     * @param stack
     * @param opCount
     * @return
     */
    public static double testStack(Stack<Integer> stack, int opCount) {

        long beginTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - beginTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 1000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack time: " + time1 + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack time:" + time2 + "s");

    }

}
