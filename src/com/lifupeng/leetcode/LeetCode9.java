package com.lifupeng.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @url: https://leetcode-cn.com/problems/palindrome-number/
 */
public class LeetCode9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
    }

    //字符串法 性能低
    public static boolean isPalindrome1(int x) {
        //小于0直接false
        if(x<0){
            return false;
        }
        List list = new LinkedList();
        //转字符串判断
        String str = x+"";
        char[] chars = str.toCharArray();
        int len = chars.length;
        //双指针法
        int last = len-1;
        int start = 0;
        while (last>start){
            if (chars[last]!=chars[start]){
                return false;
            }
            last--;
            start++;
        }
        return true;
    }
    //字符串法
    public static boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x>revertedNumber){
            revertedNumber=revertedNumber*10+x%10;
            x=x/10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x==revertedNumber || x == revertedNumber/10;
    }
}
