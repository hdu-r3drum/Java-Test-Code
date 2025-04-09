package com.algorithm;
/*
 * @lc app=leetcode id=18 lang=java
 * @lcpr version=30100
 *
 * [18] 4Sum
 */

// package leetcode.editor.en;

import java.lang.reflect.Array;
import java.util.*;
// import leetcode.editor.common.*;

public class FourSum {

    // @lc code=start
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;
            if(n < 4){
                return res;
            }
            Arrays.sort(nums);
            for(int i = 0; i < n - 3; ){
                for(int j = i + 1; j < n - 2;){
                    int low = j + 1;
                    int high = n - 1;
                    while(low < high){
                        long sum = (long)(nums[i] + nums[j] + nums[low] + nums[high]);
                        if(sum == target){
                            List<Integer> ls = new ArrayList<>();
                            ls.add(nums[i]);
                            ls.add(nums[j]);
                            ls.add(nums[low]);
                            ls.add(nums[high]);
                            res.add(ls);
                            low++;
                            while (low < high && nums[low] == nums[low - 1]) low++;
                            // high--;
                            // while (low < high && nums[high] == nums[high + 1]) high--;
                            // System.out.println(ls.toString());
                            // break;
                            // i++;
                        }else if(sum < target){
                            low++;
                            while (low < high && nums[low] == nums[low - 1]) low++;
                        }else{
                            high--;
                            while (low < high && nums[high] == nums[high + 1]) high--;
                        }
                    }
                    j++;
                    while (j < n - 2 && nums[j] == nums[j - 1]) j++;
                }
                i++;
                while (i < n - 3 && nums[i] == nums[i - 1]) i++;
            }
            return res;
        }
    }
    // @lc code=end
    public static boolean addWithoutOverflow(int a, int b) {
        if (a > 0 && b > 0) {
            if (a > Integer.MAX_VALUE - b) {
                return false;
            }
        } else if (a < 0 && b < 0) {
            if (a < Integer.MIN_VALUE - b) {
                return false;
            }
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        int[] test1 = {-2,-1,-1,1,1,2,2};
        int[] test2 = {2,2,2,2,2};
        int[] test3 = {-3,-2,-1,0,0,1,2,3};
        int[] test4 = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> lst = solution.fourSum(test4 , -294967296);
        System.out.println(lst.toString());
        System.out.println(1000000000 * 4);
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,0,-1,0,-2,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [2,2,2,2,2]\n8\n
// @lcpr case=end

 */

