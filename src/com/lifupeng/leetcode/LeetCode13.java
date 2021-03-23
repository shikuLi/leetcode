package com.lifupeng.leetcode;

/**
 * @url: https://leetcode-cn.com/problems/roman-to-integer/
 */
public class LeetCode13 {
    public static int number[] = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    public static String romaNumber[] = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int length = number.length;
        int result = 0;
        for (int i=0;i<length;i++){
            while (s.startsWith(romaNumber[i])){
                result += number[i];
                s = s.substring(romaNumber[i].length());
            }
        }
        return result;
    }
}
