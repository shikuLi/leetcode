package com.lifupeng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @url: https://leetcode-cn.com/problems/coin-change/
 */
public class LeetCode322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{186,419,83,408},6249));
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int result =0;
        return digui(coins,amount,result,coins.length-1);
    }

    public static int digui(int[] coins, int amount,int result,int start){
        List<Integer> list = new ArrayList<>();
        for (int i=start;i>=0;i--){
            int value = coins[i];
            if (value>amount){
                continue;
            }
            //减最大的数
            int duct = amount-value;
            int t = result+1;
            if (duct==0){
                return t;
            }
            int digui = digui(coins, duct, t,i);
            if (digui!=-1){
                list.add(digui);
            }
        }
        if (list.size()==0){
            return -1;
        }else {
            return Collections.min(list);
        }
    }


}
