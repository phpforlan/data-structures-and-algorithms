package com.imooc.data.structure;

public class Array {

    private int[] data; //静态数组

    private int size; //数组大小

    /**
     * 构造函数,传入数组的容量capacity构造array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }


    /**
     * 无参构造函数，默认capacity容量=10
     */
    public Array() {
        this(10);
    }


    /**
     * 获取数组的元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }


    /**
     * 获取数组的容量大小
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }


    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 向数组末尾添加元素
     *
     * @param element
     */
    public void addLast(int element) {
        add(size, element);
    }


    /**
     * 向数组开始添加元素
     *
     * @param element
     */
    public void addFirst(int element) {
        add(0, element);
    }


    /**
     * 向指定位置插入元素
     *
     * @param index   位置索引(从0开始)
     * @param element
     */
    public void add(int index, int element) {

        if (size == data.length) {
            throw new IllegalArgumentException("add element failed, Array is full");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add element failed, index is wrong, max num of index is " + size);
        }

        //1.把指定索引后的元素全部向后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        //2.赋新值
        data[index] = element;

        //3.数组大小加1
        size++;
    }


    /**
     * 根据索引获取获取指定元素
     *
     * @param index 索引位置(从0开始)
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed, index out of range");
        }

        return data[index];
    }


    /**
     * 修改指定索引的元素值
     *
     * @param index   索引位置(从0开始)
     * @param element
     */
    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed, index out of range");
        }

        data[index] = element;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append(String.format("Array: size=%d capacity=%d\n", size, data.length));
        res.append('[');

        for (int i = 0; i < size; i++) {
            res.append(data[i]);

            if (i != size - 1) {
                res.append(", ");
            }
        }

        res.append(']');

        return res.toString();
    }

}
