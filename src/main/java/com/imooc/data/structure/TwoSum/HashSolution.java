package com.imooc.data.structure.TwoSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和
 * <p>
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
public class HashSolution {

    public static void main(String[] args) {

        HashSolution hashSolution = new HashSolution();

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] res = hashSolution.twoSum(nums, target);

        System.out.println(Arrays.toString(res));
    }

    /**
     * 两遍哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSum(int[] nums, int target) {

        //通过哈希表，降低元素查找时间复杂度
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i); //key是值，value是索引
        }

        int[] res = new int[2];

        //遍历查询元素,判断hashMap中是否存在target-nums[j]
        for (int j = 0; j < nums.length; j++) {

            int complement = target - nums[j];

            if (hashMap.containsKey(complement) && hashMap.get(complement) != j) {

                return new int[]{j, hashMap.get(complement)};
            }
        }

        throw new IllegalArgumentException("No two sum solution.");
    }

}
