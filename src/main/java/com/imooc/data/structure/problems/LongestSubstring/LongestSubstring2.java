package com.imooc.data.structure.problems.LongestSubstring;

import java.util.HashSet;
import java.util.Set;

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
public class LongestSubstring2 {

    /**
     * 子串类似切片的概念(超时，太耗时了)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {

                String subString = s.substring(i, j);
                boolean isAllUnique = allUnique(subString);

                if (isAllUnique && subString.length() > maxLength) {
                    maxLength = subString.length();
                }
            }
        }

        return maxLength;
    }


    /**
     * 判断某个字符串内的字符是否全部唯一不重复
     *
     * @param s
     * @return boolean true表示全部不重复，false表示有重复字符
     */
    public Boolean allUnique(String s) {

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (set.contains(c)) {
                return false;
            }

            set.add(c);
        }

        return true;
    }

    public static void main(String[] args) {

        LongestSubstring2 longestSubstring2 = new LongestSubstring2();
        int maxLength = longestSubstring2.lengthOfLongestSubstring(" ");
        System.out.println(maxLength);
    }

}
