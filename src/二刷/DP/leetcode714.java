package 二刷.DP;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * DATE: 2021/5/27
 * Author: (Chen)
 */
/*
买卖股票的最佳时机含手续费
输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
输出: 8
解释: 能够达到的最大利润:
在此处买入prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
public class leetcode714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }

    public static void main(String[] args) {
        int[] ts = {1,3,2,8,4,9};
        int fee =2;
        int res = new leetcode714().maxProfit(ts,fee);
        System.out.println(res);
    }
    public int maxProfit1(int[] prices, int fee) {
        int n = prices.length;
//        int[][] dp = new int[n][2];
        int dp0 = 0;
        int dp1 = -prices[0];
        for(int i=1;i<n;i++){
            dp0 = Math.max(dp0,dp1+prices[i]-fee);
            dp1 = Math.max(dp1,dp0-prices[i]);
        }
        return Math.max(dp0,dp1);
    }

}
