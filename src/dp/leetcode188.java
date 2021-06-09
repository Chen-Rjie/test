package dp;

public class leetcode188 {
    public int maxProfit(int k, int[] prices) {
        int len1 = prices.length;
        if(len1==0)
            return 0;
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
        for(int i=len1-1;i>=0;i--){
            for(int j=k;j>=0;j--){
                for(int m=1;m>=0;m--){
                    if(j==k&&m==0){
                        dp[i][j][m] = 0;
                    }
                    else if(m==1){
                        dp[i][j][m] = Math.max(dp[i+1][j][m-1]+prices[i],dp[i+1][j][m]);
                    }
                    else {
                        dp[i][j][m] = Math.max(dp[i+1][j+1][1]-prices[i],dp[i+1][j][m]);
                    }
                }
            }
        }
        return dp[0][0][0];
    }
}
