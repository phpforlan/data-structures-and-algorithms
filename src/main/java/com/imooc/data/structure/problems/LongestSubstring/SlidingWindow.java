package com.imooc.data.structure.problems.LongestSubstring;

import java.util.HashSet;

/**
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
public class SlidingWindow {

    /**
     * 利用滑动窗口算法实现
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        int length = s.length();
        int begin = 0;
        int end = 0;

        HashSet<Character> hashSet = new HashSet<>(); //不重复元素的个数，也就是最长子串
        int maxLength = 0;
        while (begin < length && end < length) {

            if (!hashSet.contains(s.charAt(end))) {
                hashSet.add(s.charAt(end));
                maxLength = Math.max(maxLength, end - begin + 1);
                end++;
            } else { //已经存在该字符

                hashSet.remove(s.charAt(begin));
                begin++;
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {

        SlidingWindow slidingWindow = new SlidingWindow();
        int maxLength = slidingWindow.lengthOfLongestSubstring("abcabcbb");
        System.out.println(maxLength);

    }
}
