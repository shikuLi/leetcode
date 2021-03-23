package com.lifupeng.leetcode;

import java.util.*;

/**
 * @url: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LeetCode17 {



    public static List<String> letterCombinations(String digits) {
        Map<Character,List<Character>> map = generaterMap();
        char[] chars = digits.toCharArray();
        List<String> result= new LinkedList<>();
        boolean first = true;
        for (char aChar : chars) {
            List<Character> characters = map.get(aChar);
            int size = result.size();
            for (Character character : characters) {
                //第一次
                if (first){
                    result.add(character.toString());
                    continue;
                }

                //入栈  添加数据
                for (int i = 0; i < size; i++) {
                    result.add(result.get(i)+character);
                }

            }
            for (int i = 0; i < size; size--) {
                //出栈
                String remove = result.remove(i);
            }
            first = false;
        }

        return result;
    }

    private static Map<Character, List<Character>> generaterMap() {
        Map<Character, List<Character>>  map = new HashMap();
        char chars = 'a';
        for (char c='2';c<='9';c++){
            List<Character> list = new ArrayList();
            boolean b = true;
            for (int i = 0; i < 3; i++,chars++) {
                list.add(chars);
                if ((c=='7'||c=='9')&&b){
                    i--;
                    b=false;
                }
            }
            map.put(c,list);
        }

        return map;
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("2");
        new HashMap(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        System.out.println(list);
    }
}
