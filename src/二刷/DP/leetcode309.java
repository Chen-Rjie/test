package 二刷.DP;

/**
 * DATE: 2021/5/27
 * Author: (Chen)
 */
/*
输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
含有冷冻期
 */
public class leetcode309 {
    public int maxProfit(int[] prices) {
        int lenp = prices.length;
//        int[][] dp = new int[lenp][3];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        dp[0][2] = 0;
        int dp0 = 0,dp1 =-prices[0],dp2=0;
        for(int i=1;i<lenp;i++){
            int t1  = Math.max(dp0,dp2);
            int t2 = Math.max(dp1,dp0-prices[i]);
            int t3 = dp1 +prices[i];
            dp0 = t1;
            dp1 = t2;
            dp2 = t3;
        }
        return Math.max(dp2,dp0);
//        return Math.max(dp[lenp-1][2],dp[lenp-1][0]);
    }
}
