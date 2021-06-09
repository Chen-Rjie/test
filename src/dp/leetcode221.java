package dp;
/*
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
输入：
matrix = [["1","0","1","0","0"],
          ["1","0","1","1","1"],
          ["1","1","1","1","1"],
          ["1","0","0","1","0"]]

输出：4
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

//    public static void main(String[] args) {
//        int[][] ts = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
//        new leetcode221().maximalSquare(ts);
//    }
}
