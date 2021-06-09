package dfs;

import java.util.HashMap;
import java.util.Map;

public class leetcode494 {
//    int count = 0;
//    int len;
//    public int findTargetSumWays(int[] nums, int S) {
//        len = nums.length;
//        dfs(0,0,S,nums);
//        return count;
//    }
//    public void dfs(int index,int sum,int target,int[] nums)
//    {
//        if(index==len)
//        {
//            if(sum==target)
//                count++;
//        }
//        else
//        {
//            dfs(index+1,sum+nums[index],target,nums);
//            dfs(index+1,sum-nums[index],target,nums);
//        }
//
//
//    }

    //dp做法
    public class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int[][] dp = new int[nums.length][2001];
            dp[0][nums[0] + 1000] = 1;
            dp[0][-nums[0] + 1000] += 1;
            for (int i = 1; i < nums.length; i++) {
                for (int sum = -1000; sum <= 1000; sum++) {
                    if (dp[i - 1][sum + 1000] > 0) {
                        dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                        dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                    }
                }
            }
            return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
        }

    }

//    Map<Integer,Integer> map = new HashMap<>();
//public int singleNumber(int[] A) {
//    // write your code here
//    if(A.length==0)
//        return 0;
//    int n = A[0];
//    for(int i=1;i< A.length;i++)
//    {
//        n = n^A[i];
//    }
//    return n;
//
//}

//    public int[] twoSum(int[] numbers, int target) {
//        // write your code here
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i=0 ;i< numbers.length;i++)
//        {
//            if(map.containsKey(target- numbers[i]))
//                return new int[]{map.get(target-numbers[i]),i};
//            map.put(numbers[i],i );
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }


//    int res = 0;
//    public int getSum(int A, int B) {
//        // Write your code here
//        for(int i=A;i<=B;i++)
//        {
//            if(i%3==0)
//                res+=i;
//        }
//        return res;
//    }


}
