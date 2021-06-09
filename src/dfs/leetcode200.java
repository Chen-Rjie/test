package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode200 {
    int[][] flag;
    int row,col,count=0;
    //dfs
//    public int numIslands(char[][] grid) {
//        row = grid.length;
//        if(row==0)
//            return 0;
//        col= grid[0].length;
//        if(col==0)
//            return 0;
//        flag = new int[row][col];
//        for(int i=0;i<row;i++)
//        {
//            for(int j=0;j<col;j++)
//            {
//                if(flag[i][j]==0&&grid[i][j]=='1')
//                {
//                    dfs(grid,i,j);
//                    count++;
//                }
//            }
//        }
//        return count;
//
//    }
//    public void dfs(char[][] gird,int r,int c)
//    {
//        if(r>=row||r<0||c>=col||c<0)
//            return;
//        if(flag[r][c]==1)
//            return;
//        flag[r][c] = 1;
//        if(gird[r][c]=='1')
//        {
//            dfs(gird, r-1, c);
//            dfs(gird, r, c-1);
//            dfs(gird,r+1,c);
//            dfs(gird, r, c+1);
//        }
//
//    }

    //BFS

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='1')
                {
                    ++count;
                    grid[i][j]='0';
                    Queue<int[]> neighbors = new LinkedList<>();
                    neighbors.offer(new int[]{i,j});
                    while (!neighbors.isEmpty())
                    {
                        int[] now = neighbors.poll();
                        int nowrow = now[0],nowcol = now[1];
                        if(nowrow-1>=0&&grid[nowrow-1][nowcol]=='1')
                        {
                            neighbors.offer(new int[]{nowrow-1,nowcol});
                            grid[nowrow-1][nowcol] = '0';
                        }
                        if(nowcol-1>=0&&grid[nowrow][nowcol-1]=='1')
                        {
                            neighbors.offer(new int[]{nowrow,nowcol-1});
                            grid[nowrow][nowcol-1]= '0';
                        }
                        if(nowrow+1<row&&grid[nowrow+1][nowcol]=='1')
                        {
                            neighbors.offer(new int[]{nowrow+1,nowcol});
                            grid[nowrow+1][nowcol] = '0';
                        }
                        if(nowcol+1<col&&grid[nowrow][nowcol+1]=='1')
                        {
                            neighbors.offer(new int[]{nowrow,nowcol+1});
                            grid[nowrow][nowcol+1]= '0';
                        }

                    }
                }
            }
        }
        return count;
    }



    public static void main(String[] a)
    {
        char[][] ts = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        int res = new leetcode200().numIslands(ts);
    }
}
