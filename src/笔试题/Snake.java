package 笔试题;

import java.io.*;
import java.util.*;

/**
 * DATE: 2021/6/10
 * Author: (Chen)
 */
public class Snake {
    static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] visited;
    static Deque<int[]> path = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        String filePath;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文本路径：");
        filePath = sc.next();
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
        System.out.println("请输入操作符：");
        while (sc.hasNext()){
            option = sc.next();
            int[] posHead = path.peekLast();
            int x = posHead[0];
            int y = posHead[1];
            switch (option){
                case "a":
                    if(y-1<0||map[x][y-1]=='x'||map[x][y-1]=='1'){
                        posPrint(path);
                        continue;
                    }
                    path.offerLast(new int[]{x,y-1});
                    path.pollFirst();
                    posPrint(path);
                    break;
                case "s":
                    if(x+1>=map.length||map[x+1][y]=='x'||map[x+1][y]=='1'){
                        posPrint(path);
                        continue;
                    }
                    path.offerLast(new int[]{x+1,y});
                    path.pollFirst();
                    posPrint(path);
                    break;
                case "d":
                    if(y+1>=map[0].length||map[x][y+1]=='x'||map[x][y+1]=='1'){
                        posPrint(path);
                        continue;
                    }
                    path.offerLast(new int[]{x,y+1});
                    path.pollFirst();
                    posPrint(path);
                    break;
                case "w":
                    if(x-1<0||map[x-1][y]=='x'||map[x-1][y]=='1'){
                        posPrint(path);
                        continue;
                    }
                    path.offerLast(new int[]{x-1,y});
                    path.pollFirst();
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
        path.offerFirst(new int[]{i,j});
        String s;
//        s.s
        visited[i][j] = 1;
        for(int[] dir:direction){
            int x = i+dir[0];
            int y = j+dir[1];
            dfs(map,x,y);
        }
    }
}
