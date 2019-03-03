package com.imooc.data.structure.stack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class Solution2 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) { //提前出现反括号
                    return false;
                }

                if (c == ')' && stack.pop() != '(') { //没有最先闭合
                    return false;
                }

                if (c == '}' && stack.pop() != '{') {
                    return false;
                }

                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
            }

        }

        if (!stack.isEmpty()) { //有多余的左括号
            return false;
        }

        return true;
    }

}
