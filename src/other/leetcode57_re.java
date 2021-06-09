package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leetcode57_re {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int left = newInterval[0],right = newInterval[1];
        for(int i=0;i<len;i++)
        {
            if(intervals[i][1]<left)
            {
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }
            else if(intervals[i][0]>right){
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }
            else {
                left = Math.min(intervals[i][0],left);
                right = Math.max(intervals[i][1],right);
            }
        }
        res.add(new int[]{left,right});
        int[][] rr = res.toArray(new int[0][]);
        Arrays.sort(rr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        return rr;
    }

    public static void main(String[] args) {
        int[][] ts = {{1,3},{6,9}};
        int[] t = {2,5};
        int[][] res = new leetcode57_re().insert(ts,t);
    }
}
