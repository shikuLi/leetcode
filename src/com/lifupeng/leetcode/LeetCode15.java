package com.lifupeng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @url: https://leetcode-cn.com/problems/3sum/
 */
public class LeetCode15 {
    public static void main(String[] args) {
        int nums[] = new int[]{1,2,-2,-1};

        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //枚举a
        for (int first=0;first<n-2;first++){
            //和上一次枚举不一样
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }
            //枚举c  尾巴位置
            int three = n-1;
            int target = -nums[first];

            //枚举b
            for (int two = first+1;two<three;two++){
                //b要和上一次不一样
                if(two>first+1&&nums[two]==nums[two-1]){
                    continue;
                }

                while (two<three&&nums[two]+nums[three]>target){
                    three--;
                }

                if(two==three){
                    break;
                }

                //相等
                if (nums[two]+nums[three]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[two]);
                    list.add(nums[three]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
