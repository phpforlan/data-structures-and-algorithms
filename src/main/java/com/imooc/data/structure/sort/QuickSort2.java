package com.imooc.data.structure.sort;

import com.imooc.data.structure.array.Array;

import java.util.Arrays;

/**
 * 快速排序，原地排序，不需要额外空间
 */
public class QuickSort2 {

    public int[] sort(int[] nums) {

        int len = nums.length;

        if (len <= 1) {
            return nums;
        }

        int middle = nums[0];

        outterLoop:
        for (int j = len - 1; j > 0; j--) { //从后往前

            if (nums[j] < middle) {

                for (int i = 0; i < len; i++) {
                    if (nums[i] > middle) { //交换

                        if (i < j) {
                            int tmp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = tmp;
                            System.out.println(i);
                            System.out.println(j);
                            System.out.println(Arrays.toString(nums));
                            System.out.println("-----");
                            break;
                        } else {
                            nums[0] = nums[j];
                            nums[j] = middle;
                            break outterLoop;
                        }
                    }
                }

            }
        }




        //System.out.println(Arrays.toString(nums));

        return nums;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{10, 12, 8, 3, 90};

        QuickSort2 quickSort2 = new QuickSort2();
        quickSort2.sort(nums);

        System.out.println(Arrays.toString(nums));
    }

}
