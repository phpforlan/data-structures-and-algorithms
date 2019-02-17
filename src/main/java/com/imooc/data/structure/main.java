package com.imooc.data.structure;

import com.imooc.data.structure.array.Array;

public class main {

    public static void main(String[] args) {

        Array<Integer> myArr = new Array<>(10);

        myArr.addLast(1);
        myArr.addLast(3);
        myArr.addLast(2);
        myArr.addLast(3);
        myArr.addLast(10);
        myArr.addLast(3);
        myArr.remove(0);

        System.out.println(myArr);
    }

}
