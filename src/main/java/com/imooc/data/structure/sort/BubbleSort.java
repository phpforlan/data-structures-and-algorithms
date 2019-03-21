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

    public static void main(String[] args) {

        int[] nums = new int[]{10, 18, 12, 6, 13};

        BubbleSort bubbleSort = new BubbleSort();
        int[] sortedNums = bubbleSort.sort(nums);

        System.out.println(Arrays.toString(sortedNums));

    }

}
