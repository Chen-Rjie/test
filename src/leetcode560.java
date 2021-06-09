/*
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 */


import java.util.HashMap;
import java.util.Map;

public class leetcode560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);//初始状态前缀和为0的只有1种，pos应该为-1 也就是说只能后面遇到前缀和为k的，起始点只能是0
        int count=0,sum=0;
        for(int i=0;i< nums.length;++i){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
