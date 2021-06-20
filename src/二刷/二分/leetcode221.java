package 二刷.二分;

/**
 * Created by Chen
 * 2021/6/19 19:25
 */
public class leetcode221 {
    public int maximalSquare(char[][] matrix) {
        int h = matrix.length;
        if(h==0)
            return 0;
        int w = matrix[0].length;
        int[][] dp = new int[h][w];
        int maxlen = 0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(matrix[i][j]=='1') {
                    if(i==0||j==0)
                    {
                        dp[i][j]=1;
                    }
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                }
                if(dp[i][j]>maxlen){
                    maxlen = dp[i][j];
                }
            }
        }
        return maxlen*maxlen;
    }
}
