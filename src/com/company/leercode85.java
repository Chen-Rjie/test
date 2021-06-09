package com.company;

public class leercode85 {
    public int maximalRectangle(char[][] matrix) {
        int len = matrix.length;
        if(len==0)
            return 0;
        int len2 = matrix[0].length;
        if(len2==0)
            return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for(int i=0;i<len;i++)
        {
            for(int j=0;j<len2;j++)
            {
                if(matrix[i][j]=='1')
                {
                    dp[i][j] = j==0?1:dp[i][j-1]+1;
                }
                else {
                    dp[i][j] = 0;
                }
                int minline = dp[i][j];
                for(int k=i;k>=0;k--)
                {
                    minline = Math.min(minline,dp[k][j]);
                    res = Math.max(res,minline*(i-k+1));
                }
            }

        }
        return res;
    }
    public static void main(String[] args)
    {
        char[][] ts = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int res = new leercode85().maximalRectangle(ts);
    }
}
