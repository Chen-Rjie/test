package 二刷.贪心;

/**
 * DATE: 2021/5/27
 * Author: (Chen)
 */
public class leetcode122 {
    public int maxProfit(int[] prices) {
        int lenp = prices.length;
        int[][] dp = new int[lenp][2];
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for(int i=1;i<lenp;i++){
            dp[i][0] = Math.max(dp[i-1][1] +prices[i],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i],dp[i-1][1]);
        }
        return Math.max(dp[lenp-1][0],dp[lenp-1][1]);
    }
    //贪心
    public int maxProfit1(int[] prices) {
        int lenp = prices.length;
        int res = 0;
        for(int i=1;i<lenp;i++){
            res += prices[i]>prices[i-1]?prices[i]-prices[i-1]:0;
        }
        return res;
    }
}
