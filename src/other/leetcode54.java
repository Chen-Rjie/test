package other;
//剑指offer第29题
//每次循环更换左上角的位置,左上角横纵坐标相等，不会超过各自长度的一半
public class leetcode54 {
    public int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if(rows==0)
            return new int[]{};
        int cols = matrix[0].length;
        int[] index = new int[]{0};
        int[] res = new int[rows*cols];
        int start = 0;
        while(start<=(cols-1)/2&&start<=(rows-1)/2)
        {
            printCycle(matrix,start,rows,cols,res,index);
            start++;
        }
        return res;

    }
    public void printCycle(int[][] matrix,int start,int rows,int cols,int[] res,int[] index)
    {
        int endX = cols-1-start;
        int endY = rows-1-start;
        for(int i=start;i<=endX;i++)
        {
            res[index[0]] = matrix[start][i];
            index[0] ++;
        }
        if(start<endY)
        {
            for(int i=start+1;i<=endY;i++)
            {
                res[index[0]] = matrix[i][endX];
                index[0]++;
            }
        }
        if(start<endX&&start<endY)
        {
            for(int i=endX-1;i>=start;i--)
            {
                res[index[0]] = matrix[endY][i];
                index[0]++;
            }
        }
        if(start<endY-1&&start<endX)
        {
            for(int i=endY-1;i>start;i--)
            {
                res[index[0]] = matrix[i][start];
                index[0]++;
            }
        }
    }
    public static void main(String[] args)
    {
        int[][] ts = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] res = new leetcode54().spiralOrder(ts);
    }
}
