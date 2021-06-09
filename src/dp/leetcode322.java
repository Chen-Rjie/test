package dp;
/*
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

你可以认为每种硬币的数量是无限的。
 */
public class leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            int mincount = 10000;
            for(int coin:coins){
                if(i-coin>=0){
                    mincount = Math.min(dp[i-coin]+1,mincount);
                }
            }
            dp[i] = mincount;
        }
        return  dp[amount]==10000?-1:dp[amount];
    }
}
