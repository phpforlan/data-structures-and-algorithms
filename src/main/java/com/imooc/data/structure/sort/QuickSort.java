package com.imooc.data.structure.sort;

import com.imooc.data.structure.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 快速排序，采用分而治之思想
 */
public class QuickSort {

    /**
     * 从小到大排序
     *
     * @param nums
     * @return
     */
    public ArrayList<Integer> sort(ArrayList<Integer> nums) {

        if (nums.size() <= 1) {
            return nums;
        }

        int middle = nums.get(0); //中间的数

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> mergeResult = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) { //开始将数组分成两部分
            if (nums.get(i) < middle) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        mergeResult.addAll(sort(left));
        mergeResult.add(middle);
        mergeResult.addAll(sort(right));
        return mergeResult;
    }


    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<Integer>() {{
            add(1);
            add(10);
            add(5);
            add(18);
            add(10);
        }};

        QuickSort quickSort = new QuickSort();
        ArrayList<Integer> sortedNums = quickSort.sort(nums);
        System.out.println(sortedNums);

    }

}
