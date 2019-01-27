package com.imooc.data.structure;

public class main {

    public static void main(String[] args) {

        Array myArr = new Array(20);
        myArr.addFirst(100);
        myArr.addLast(99);
        myArr.addFirst(101);

        System.out.println(myArr);
    }
}
