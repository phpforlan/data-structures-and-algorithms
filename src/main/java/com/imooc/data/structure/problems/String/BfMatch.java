package com.imooc.data.structure.problems.String;

/**
 * 从目标字符串T中，找出是否存在模式串P，如果存在则返回起始索引，否则返回-1
 * <p>
 * BF算法的算法思想是：
 * 从目标串T的的第一个字符起与模式串P的第一个字符比较。若相等，则继续对字符进行后续的比较；
 * 否则目标串从第二个字符起与模式串的第一个字符重新比较。直至模式串中的每个字符依次和目标串中的一个连续的字符序列相等为止，
 * 此时称为匹配成功，否则匹配失败。
 */
public class BfMatch {

    /**
     * bf算法
     *
     * @param target
     * @param pattern
     * @return
     */
    public int bfMatch(String target, String pattern) {

        int i = 0; //目标字符串T起始位置
        int j = 0; //模式串P开始位置
        int pos = -1; //已匹配，模式串在目标串的起始位置

        while (i < target.length()) {

            while (target.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j >= pattern.length()) {

            }

        }

        return 0;
    }


}
