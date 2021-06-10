package 笔试题;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * DATE: 2021/6/10
 * Author: (Chen)
 */
public class Snake_back {
    static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] visited;
    static Deque<int[]> path = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        String filePath = "E:/map.txt";
        Scanner sc = new Scanner(System.in);
        FileInputStream fin = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buffReader = new BufferedReader(reader);
        String strTmp = "";
        int row,col;
        int rowIndex = 0,colIndex=0;
        int headPosCol = 0,headPosRow=0;
        char[][] map=new char[1][1];
        int flag = 0,flagPosHead=0;
        while ((strTmp = buffReader.readLine())!=null){
            if(flag==0){
                String[] tmp = strTmp.split(" ");
                row = Integer.parseInt(tmp[0]);
                col = Integer.parseInt(tmp[1]);
                map = new char[row][col];
                visited = new int[row][col];
                flag = 1;
            }
            else {
                if(flagPosHead==0){
                    int tmpPos = strTmp.indexOf('>');
                    if(tmpPos>=0){
                        headPosCol = tmpPos;
                        headPosRow = rowIndex;
                    }
                    flagPosHead = 1;
                }

                map[rowIndex++] = strTmp.toCharArray();
            }
        }
        dfs(map,headPosRow,headPosCol);
        String option;
        while (sc.hasNext()){
            option = sc.next();
            int[] posHead = path.peekFirst();
            int x = posHead[0];
            int y = posHead[1];
            switch (option){
                case "a":
                    if(y-1<0||map[x][y-1]=='x'||map[x][y-1]=='1'){
                        posPrint(path);
                        continue;
                    }
                    path.offerFirst(new int[]{x,y-1});
                    path.pollLast();
                    posPrint(path);
                    break;
                case "s":
                    if(x+1>=map.length||map[x+1][y]=='x'||map[x+1][y]=='1'){
                        posPrint(path);
                        continue;
                    }
                    path.offerFirst(new int[]{x+1,y});
                    path.pollLast();
                    posPrint(path);
                    break;
                case "d":
                    if(y+1>=map[0].length||map[x][y+1]=='x'||map[x][y+1]=='1'){
                        posPrint(path);
                        continue;
                    }
                    path.offerFirst(new int[]{x,y+1});
                    path.pollLast();
                    posPrint(path);
                    break;
                case "w":
                    if(x-1<0||map[x-1][y]=='x'||map[x-1][y]=='1'){
                        posPrint(path);
                        continue;
                    }
                    path.offerFirst(new int[]{x-1,y});
                    path.pollLast();
                    posPrint(path);
                    break;
                default:
                    System.out.println("请输入有效操作符");
            }

        }

    }
    public static void posPrint(Deque<int []> path){
        for(int[] pos:path){
            System.out.print("x="+pos[0]+",y="+pos[1]+";");
        }
        System.out.println();
    }
    public static void dfs(char[][] map,int i,int j){
        if(i<0||i>= map.length||j<0||j>=map[0].length)
            return;
        if(visited[i][j]==1||(map[i][j]!='>'&&map[i][j]!='x'))
            return;
        path.offerLast(new int[]{i,j});
        visited[i][j] = 1;
        for(int[] dir:direction){
            int x = i+dir[0];
            int y = j+dir[1];
            dfs(map,x,y);
        }
    }
}
