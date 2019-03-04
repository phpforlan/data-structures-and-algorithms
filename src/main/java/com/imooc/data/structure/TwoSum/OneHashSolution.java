package com.imooc.data.structure.TwoSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class OneHashSolution {


    /**
     * 一遍哈希表解决该问题
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int remain = target - nums[i];

            if (hashMap.containsKey(remain)) {
                return new int[]{hashMap.get(remain), i};
            }

            hashMap.put(nums[i], i);
        }


        throw new IllegalArgumentException("no solution.");
    }


    public static void main(String[] args) {

        int[] nums = new int[]{7, 2, 11, 15};
        int target = 9;
        OneHashSolution oneHashSolution = new OneHashSolution();
        int[] res = oneHashSolution.twoSum(nums, target);

        System.out.println(Arrays.toString(res));
    }


}
