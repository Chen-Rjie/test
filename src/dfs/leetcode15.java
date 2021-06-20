package dfs;

import java.util.*;

/**
 * Created by Chen
 * 2021/6/13 22:02
 */
/*
三数之和
 */
public class leetcode15 {
    //记忆化搜索
    /*Set<Integer> setOneNum = new HashSet<>();
    Set<Integer> setTwoNum = new HashSet<>();
    Set<Integer> setThrNum = new HashSet<>();
    for(int i = 0;i<)*/
//    int[] visited;
    //暴力
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        StringBuilder s;
        int len1 = nums.length;
        for(int i=0;i<len1;i++){
            if(i!=0){
                if(nums[i]==nums[i-1])
                    continue;
            }
            int right = len1-1;
            int target = 0-nums[i];
            int left = i+1;
            while (left<right){
//                if(visited[left]==1)
//                {
//                    visited[left]
//                    left++;
//                    continue;
//                }
                if(left!=i+1){
                    if(nums[left-1]==nums[left]){
                        left++;
                        continue;
                    }
                }
                if(nums[left]+nums[right]<target)
                    left++;
                else if(nums[left]+nums[right]>target)
                    right--;
                else
                {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                }
            }

        }
        return res;
        }
}
