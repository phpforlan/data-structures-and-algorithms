package com.imooc.data.structure.problems.LongestSubstring;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstring {

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        int length = s.length();

        int maxLength = 0;
        for (int i = 0; i < length; i++) {

            //从i位置开始，找字串
            TreeSet<Character> treeSet = new TreeSet<>();
            int substringLength = 0;
            for (int j = i; j < length; j++) {

                if (treeSet.contains(s.charAt(j))) { //如果已经存在，则退出循环
                    break;
                }

                substringLength++;
                treeSet.add(s.charAt(j));
            }
            treeSet.clear();

            if (substringLength > maxLength) {
                maxLength = substringLength;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        LongestSubstring longestSubstring = new LongestSubstring();
        int maxLength = longestSubstring.lengthOfLongestSubstring("abcdea");
        System.out.println(maxLength);
    }


}
