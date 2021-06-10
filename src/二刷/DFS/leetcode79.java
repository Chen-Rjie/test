package 二刷.DFS;

import java.util.Iterator;

/**
 * DATE: 2021/6/10
 * Author: (Chen)
 */
/*
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 */
public class leetcode79 {
    int[][] visited;
    int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int len1 = board.length;
        if(len1==0)
            return false;
        visited = new int[len1][board[0].length];
        boolean res = false ;
        for(int i=0;i<len1;i++){
            for(int j=0;j<board[0].length;j++){
                res = dfs(board,word,0,i,j);
                if(res == true)
                    return res;
            }
        }
        return res;
    }
    public boolean dfs(char[][] board,String word,int index,int i,int j){
        boolean res = false;
        if(index==word.length())
            return true;
        if(board[i][j]!=word.charAt(index)||visited[i][j]==1)
            return false;
        visited[i][j] = 1;
        for(int[] dic:direction){
            int x = i+ dic[0];
            int y = j+ dic[1];
            if(x<0||x>= board.length||y<0||y>= board[0].length)
            {
                if(index+1 == word.length())
                    return true;
                continue;
            }
            res = dfs(board,word,index+1,x,y);
            if(res==true){
                break;
            }
        }
        visited[i][j] = 0;
        return res;
    }
}
