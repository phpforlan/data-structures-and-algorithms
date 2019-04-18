package com.imooc.data.structure.sort;


import java.util.Arrays;

/**
 * 快速排序，原地排序，不需要额外空间
 */
public class QuickSort2 {

    /**
     * 从小到大排序
     *
     * @param nums
     * @param low  起始位置索引
     * @param high 结束位置索引
     * @return
     */
    public void sort(int[] nums, int low, int high) {

        int i = low;
        int j = high;
        int middle = nums[low];

        while (i < j) {

            while (i < j && nums[j] > middle) { //从后往前，只要nums[j] > middle，则继续前移
                j--;
            }

            nums[low] = nums[j];

            while (i < j && nums[i] <= middle) {
                i++;
            }


        }


    }


    public static void main(String[] args) {

        int[] nums = new int[]{10, 12, 8, 3, 90};

        QuickSort2 quickSort2 = new QuickSort2();
        quickSort2.sort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

}
