package com.imooc.data.structure;

import com.imooc.data.structure.array.Array;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        Array<Integer> myArr = new Array<>();
        
        myArr.addLast(1);
        myArr.addLast(3);
        myArr.add(1,2);
        myArr.removeElement(3);

        System.out.println(myArr);
    }

}
