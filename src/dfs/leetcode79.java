package dfs;
/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 */
public class leetcode79 {
    int[][] direction = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    int[][] visited;
    public boolean exist(char[][] board, String word) {

        int len1 = board.length;
        int len2 = board[0].length;
        visited= new int[len1][len2];
        boolean res = false;
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                res = dfs(board,word,0,i,j);
                if(res==true)
                    return res;
            }
        }
        return res;
    }
    public boolean dfs(char[][] board,String word,int index,int i,int j){
        if(index==word.length())
            return true;
        if(word.charAt(index)!= board[i][j]||visited[i][j]==1)
            return false;

        visited[i][j] = 1;
        boolean result = false;
        for(int[] direc: direction){
            int x = i+direc[0];
            int y = j+direc[1];

            if(x<0||y<0||x>=board.length||y>= board[0].length){
                if(index+1==word.length())
                    return true;
                continue;
            }

            result = dfs(board,word,index+1,x,y);
            if(result==true)
                break;
        }
        visited[i][j] = 0;
        return result;
    }

    public static void main(String[] args) {

        char[][] ts = new char[][]{{'a'}};
        //        char[][] ts = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String str = "ABCCED";
        String str = "a";
        boolean res = new leetcode79().exist(ts,str);
    }
}
