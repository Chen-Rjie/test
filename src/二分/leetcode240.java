package 二分;
import java.util.*;
public class leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len1 = matrix.length;
        if(len1==0)
            return false;
        int len2 = matrix[0].length;
        if(len2==0)
            return false;
        return search(matrix,target,0,0, matrix.length-1, matrix[0].length-1 );
    }
    public boolean search(int[][] matrix,int target,int x1,int y1,int x2,int y2){
        if(x1>x2||y1>y2)
            return false;
        if(target<matrix[x1][y1]||target>matrix[x2][y2]){
            return false;
        }

        int midx = (x1+x2)/2,midy = (y1+y2)/2;
        if(matrix[midx][midy]==target)
            return true;
        if(matrix[midx][midy]<target){
            return search(matrix, target, x1, midy+1, midx, y2)|| search(matrix, target, midx+1, midy+1, x2, y2)||
                    search(matrix,target,midx+1,y1,x2,midy);
        }
        else {//target不在第四象限
            return search(matrix,target,x1,y1,midx-1,midy-1) ||
                    search(matrix,target,x1,midy,midx-1,y2) ||
                    search(matrix,target,midx,y1,x2,midy-1);
        }

    }

    public static void main(String[] args) {

    }
}
