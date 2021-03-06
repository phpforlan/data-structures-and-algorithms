package com.imooc.data.structure.sort;

import java.util.Arrays;

/**
 * 冒泡排序实现
 */
public class BubbleSort {

    /**
     * 从小到大排序
     *
     * @param nums
     * @return
     */
    public int[] sort(int[] nums) {

        if (nums.length <= 1) {
            return nums;
        }

        int len = nums.length;

        for (int i = 0; i < len - 1; i++) { //比较轮数

            for (int j = 0; j < len - i - 1; j++) { //每轮比较的次数,从第一个数开始，每次把最大的数放到最后

                if (nums[j] > nums[j + 1]) {

                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        return nums;
    }


    /**
     * 从大到小排序
     *
     * @param nums
     * @return
     */
    public int[] sort2(int[] nums) {

        if (nums.length <= 1) {
            return nums;
        }

        int len = nums.length;

        for (int i = 0; i < len - 1; i++) { //比较轮数

            for (int j = 0; j < len - i - 1; j++) { //比较次数

                if (nums[j] < nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        return nums;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{10, 18, 12, 6, 13};

        //从小到大排序
        BubbleSort bubbleSort = new BubbleSort();
        int[] sortedNums = bubbleSort.sort(nums);
        System.out.println(Arrays.toString(sortedNums));

        //从大到小排序
        int[] sortNums2 = bubbleSort.sort2(nums);
        System.out.println(Arrays.toString(sortedNums));

    }

}
