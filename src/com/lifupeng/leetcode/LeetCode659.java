package com.lifupeng.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @url: https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 *
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 */
public class LeetCode659 {
    //贪心算法
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        Map<Integer,Integer> endMap = new HashMap<>();
        for (int num : nums) {
            int count = countMap.getOrDefault(num,0)+1;
            countMap.put(num,count);
        }

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0);
            if (count>0){
                int prevEndCount = endMap.getOrDefault(num-1,0);
                if (prevEndCount>0){
                    countMap.put(num,count-1);
                    endMap.put(num,endMap.getOrDefault(num,0)+1);
                    endMap.put(num-1,prevEndCount-1);
                }else {
                    int count1 = countMap.getOrDefault(num + 1, 0);
                    int count2 = countMap.getOrDefault(num + 2, 0);
                    if (count1>0&&count2>0){
                        endMap.put(num+2,endMap.getOrDefault(num+2,0)+1);
                        countMap.put(num,count-1);
                        countMap.put(num+1,count1-1);
                        countMap.put(num+2,count2-1);
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
