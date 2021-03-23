package com.lifupeng.leetcode;

/**
 * @url: https://leetcode-cn.com/problems/integer-to-roman/
 */
public class LeetCode12 {
    public static void main(String[] args) {
        String s = intToRoman(1994);
        System.out.println(s);
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        //除1000：M、500：D、100：C、50：L、10：X、5：V、1：I

        num =addTransString(num,sb, 1000,"M");
        num =addTransString(num,sb, 900,"CM");
        num =addTransString(num,sb, 500,"D");
        num =addTransString(num,sb, 400,"CD");
        num =addTransString(num,sb, 100,"C");
        num =addTransString(num,sb, 90,"XC");
        num =addTransString(num,sb, 50,"L");
        num =addTransString(num,sb, 40,"XL");
        num =addTransString(num,sb, 10,"X");
        num =addTransString(num,sb, 9,"IX");
        num =addTransString(num,sb, 5,"V");
        num =addTransString(num,sb, 4,"IV");
        num =addTransString(num,sb, 1,"I");
        return sb.toString();
    }

    public static int addTransString(int num,StringBuilder sb,int size,String s){
        int count = num/size;
        if (count==0){
            return num;
        }
        for (int i = 0; i < count; i++) {
            sb.append(s);
        }
        num = num%size;
        return num;
    }
}
