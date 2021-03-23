package com.lifupeng.leetcode;

/**
 * @url: https://leetcode-cn.com/problems/create-maximum-number/
 */
public class LeetCode321 {
    public static void main(String[] args) {
        int[] num1 = new int[]{3, 4, 6, 5};
        int[] num2 = new int[]{9, 1, 2, 5, 8, 3};
        int k = 5;
        int[] ints = maxNumber(num1, num2, k);
        for (int anInt : ints) {
            System.out.print(anInt+",");
        }

        //9,8,6,5,3

    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int [] maxSubsequence = new int[k];
        int m = nums1.length;
        int n = nums2.length;
        int start = Math.max(0,k-n),end = Math.min(k,m);
        for (int i=start;i<=end;i++){
            //查出最大子序列
            int[] subsequence1 = maxSubsequence(nums1,i);
            int[] subsequence2 = maxSubsequence(nums2,k-i);
            //合并最大子序列
            int[] curMaxSubsequence = merge(subsequence1,subsequence2);
            if (compare(curMaxSubsequence,0,maxSubsequence,0)){
                System.arraycopy(curMaxSubsequence,0,maxSubsequence,0,k);
            }

        }

        return maxSubsequence;
    }

    private static boolean compare(int[] curMaxSubsequence,int index1, int[] maxSubsequence,int index2) {
        int m=curMaxSubsequence.length,n=maxSubsequence.length;
        while (index1<m||index2<n){
            if (index1>=m){
                return false;
            }
            if (index2>=n){
                return true;
            }
            if (curMaxSubsequence[index1]==maxSubsequence[index2]){
                index1++;
                index2++;
            }else if (curMaxSubsequence[index1]>maxSubsequence[index2]){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    private static int[] merge(int[] subsequence1, int[] subsequence2) {
        int m = subsequence1.length,n=subsequence2.length;
        int mergeLength = m+n;
        int[] result = new int[mergeLength];
        int index1=0,index2=0;
        for(int i=0;i<mergeLength;i++){
            if (compare(subsequence1,index1,subsequence2,index2)){
                result[i]=subsequence1[index1++];
            }else {
                result[i]=subsequence2[index2++];
            }
        }
        return result;
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }


}
