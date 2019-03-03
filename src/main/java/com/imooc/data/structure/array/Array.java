package com.imooc.data.structure.array;

import java.util.Arrays;

/**
 * 基于java静态数组，封装一个动态数组，提供更加丰富的功能
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

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
     * 向数组末尾添加一个元素
     *
     * @param e 时间复杂度: O(1)
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向数组头部添加一个元素
     * 时间复杂度: O(n)
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }


    /**
     * 向数组中的指定索引位置插入一个元素
     * 时间复杂度: O(n/2) => O(n)
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (size == data.length) {
            resize(2 * data.length); //扩容
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get failed, index is illegal");
        }

        //把index之后的所有元素后移一位(含index)
        for (int k = size - 1; k >= index; k--) {
            data[k + 1] = data[k];
        }

        data[index] = e;
        size++;
    }


    /**
     * 按照指定capacity，给数组动态伸缩
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) { //原来数组元素复制到新数组中
            newData[i] = data[i];
        }

        data = newData;
    }

    /**
     * 获取某个元素
     *
     * @param index
     * @return
     */
    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed, index is illegal");
        }
        return data[index];
    }

    /**
     * 获取数组中的最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }


    /**
     * 获取数组中的第一个元素
     *
     * @return
     */
    public E getFirst() {
        
        return get(0);
    }

    /**
     * 修改某个元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed, index is illegal");
        }

        data[index] = e;
    }

    /**
     * 查询数组是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 查看数组中元素e所在的索引，如果不存在，则返回-1
     */
    public int find(E e) {

        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }

        return -1;
    }


    /**
     * 查询元素e在数组中的所有索引，如果不存在，则返回[]
     *
     * @param e
     * @return
     */
    public int[] findAll(E e) {

        int[] result = new int[size];

        int k = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                result[k] = i;
                k++;
            }
        }

        result = Arrays.copyOf(result, k); //数组缩容

        return result;
    }


    /**
     * 删除指定索引的元素,且返回删除的元素
     *
     * @param index
     */
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("del failed, index is illegal");
        }

        //从index后的元素开始，依次往前移动一位(不含index)
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        data[size - 1] = null; //loitering objects != memory leak
        size--;

        if (size == data.length / 4 && data.length / 2 != 0) { //缩小容量(lazy策略)
            resize(data.length / 2);
        }

        return data[index];
    }

    /**
     * 删除数组中的某个元素(只删除一个)
     *
     * @param e
     */
    public boolean removeElement(E e) {

        int index = find(e);

        if (index != -1) {
            remove(index);
            return true;
        }

        return false;
    }


    /**
     * 删除数组中所有的指定元素
     *
     * @param e
     * @return
     */
    public boolean removeAllElement(E e) {

        int[] indexArr = findAll(e);

        System.out.println(indexArr);

        for (int index : indexArr) {
            System.out.println(index);
            //remove(index);
        }

        return indexArr.length == 0;
    }

    /**
     * 删除头部元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除末尾元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {

        String str = "Array: size = " + size + ", capacity = " + data.length + "\n[";

        for (int i = 0; i < size; i++) {
            str = str + data[i] + ",";
        }

        str = str.substring(0, str.length() - 1) + "]";

        return str;
    }

}
