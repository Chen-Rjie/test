package 二刷.DFS;

/**
 * DATE: 2021/6/7
 * Author: (Chen)
 */
public class leetcode200 {
    int res = 0;
    public int numIslands(char[][] grid) {
        int len1 = grid.length;
        if(len1==0)
            return 0;
        if(grid[0].length==0)
            return 0;
        int[][] visited = new int[len1][];
        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if(grid[i][j]=='1'){
//                      if(visited[i][j]==0){
//                          visited[i][j]=1;
//                          numIslands(grid);
                    dfs(grid,i,j);
                    ++res;
//                      }


                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid,int r,int c){
        int nr = grid.length;
        int nc = grid[0].length;
        if(r<0||c<0||r>=nr||c>=nc||grid[r][c]=='0')
            return;
        grid[r][c]='0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

}
