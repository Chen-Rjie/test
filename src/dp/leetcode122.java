package dp;
//输入: [7,1,5,3,6,4]
//        输出: 7
//        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//             随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

public class leetcode122 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]<prices[i]){
                dp[i] = dp[i-1]+prices[i]-prices[i-1];
            }
            else {
                dp[i] = dp[i-1];
            }
        }
        int res = dp[0];
        for(int i=0;i<prices.length;i++){
            if(dp[i]>res){
                res = dp[i];
            }
        }
        return res;
    }
}
