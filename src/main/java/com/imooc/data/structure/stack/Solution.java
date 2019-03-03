package com.imooc.data.structure.stack;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

/**
 * leetCode: 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Solution {

    public static void main(String[] args) {
        String s = "{}[]{[](})";

        Solution solution = new Solution();
        boolean isValid = solution.isValid(s);

        System.out.println(isValid);
    }


    /**
     * 判断字符串是否有效(利用栈来实现) 后进先出
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        ArrayStack<Character> stack = new ArrayStack<>();

        for (int i = 0; i < s.length(); i++) {

            char item = s.charAt(i);

            if (item == '(' || item == '{' || item == '[') {
                stack.push(s.charAt(i));
            } else if (item == ')' && !stack.isEmpty() && stack.pop() != '(') {
                return false;
            } else if (item == '}' && !stack.isEmpty() && stack.pop() != '{') {
                return false;
            } else if (item == ']' && !stack.isEmpty() && stack.pop() != '[') {
                return false;
            }
        }

        return true;
    }

}
