package com.imooc.data.structure.reverse;

/**
 * 7. 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 */
public class Reverse {

    /**
     * 实现思路，每次把x的最低位取出来，附加反转结果result中
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        long res = 0; //长整数

        while (x != 0) {

            res = res * 10 + x % 10; //每次取出x的最低位，附加结果的右侧位置

            x = x / 10;
        }

        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int) res;
    }


    public static void main(String[] args) {

        Reverse reverse = new Reverse();
        int result = reverse.reverse(-123);

        System.out.println(result);
    }

}
