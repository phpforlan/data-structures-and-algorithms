package com.imooc.data.structure;

public class main {

    public static void main(String[] args) {

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int item : arr) { //foreach
            //System.out.println(item);
        }

        int[] scores = new int[]{100, 99, 98};
        for (int i = 0; i < scores.length; i++) {
            //System.out.println(scores[i]);
        }

        scores[0] = 98;
        for (int score : scores) {
            System.out.println(score);
        }

    }
}
