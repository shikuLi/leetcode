package com.lifupeng.leetcode;

/**
 * @url: https://leetcode-cn.com/problems/count-primes/
 */
public class LeetCode204 {
    public int countPrimes(int n) {
        int result =0;
        for(int i=2;i<n;i++){
            result += isPrime(i)?1:0;
        }
        return result;
    }

    public static boolean isPrime(int prime){
        for(int i=2;i*i<=prime;i++){
            if(prime%i==0){
                return false;
            }
        }
        return true;
    }
}
