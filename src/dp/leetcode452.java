package dp;
import java.util.*;
public class leetcode452 {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if(len==0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        int count=0,index = points[0][1];
        for(int i=0;i< points.length;i++){
            if(points[i][0]>index){
                count++;
                index = points[i][0];
            }
        }
        count++;
        return count;
    }
}
