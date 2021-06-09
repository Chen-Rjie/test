package 二刷.DP;

/**
 * DATE: 2021/5/27
 * Author: (Chen)
 */
/*
给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 */
public class leetcode188 {
    public int maxProfit(int k, int[] prices) {
        int len1 = prices.length;
        if(len1==0)
            return 0;
        //三维DP  其中第二维表示正在进行第几笔交易，第三维表示进行这笔交易后还剩多少只股票，第一维表示以当前条件开始的最大利润
        //正在进行第j次交易且剩余有m只股票 在这种情况下能产生的最大利润
        int[][][] dp = new int[len1+1][k+1][2];
        int pre = prices[0];
        if(k>len1/2){
            int res = 0;
            for(int i=1;i<len1;i++){
                if(prices[i]>pre){
                    res += prices[i]-pre;
                }
                pre = prices[i];
            }
            return res;
        }
        for(int i=len1-1;i>=0;i++){
            for(int j=k;j>=0;j--){
                for(int m=1;m>=0;m--){
                    if(j==k&&m==1){
                            dp[i][j][m]=0;
                    }
                    else if(m==1){
                        dp[i][j][m] = Math.max(dp[i+1][j][m],dp[i+1][j][m-1]);
                    }
                    else {
                        dp[i][j][m] = Math.max(dp[i+1][j][m],dp[i+1][j][m+1]-prices[i]);
                    }
                }
            }
        }
        return dp[0][0][0];
    }
}
