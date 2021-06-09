package dfs;
//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//        说明：每次只能向下或者向右移动一步。
public class leetcode64 {
    public int minPathSum(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int[][] dp = new int[h][w];
        dp[0][0] = grid[0][0];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(i==0&&j==0){
                    dp[i][j] = grid[i][j];
                }
                else if(i==0){
                    dp[i][j] = dp[i][j-1]+ grid[i][j];
                }
                else if(j==0){
                    dp[i][j] = dp[i-1][j]+ grid[i][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }

            }
        }
        return dp[h-1][w-1];

    }
//    public void dfs(int[][] grid,int w,int h){
//
//    }


    public static void main(String[] args) {
        int[][] ts = {{1,3,1},{1,5,1},{4,2,1}};
        int res = new leetcode64().minPathSum(ts);
    }

}
