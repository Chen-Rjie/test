package other;
import java.util.*;
public class leetcode57_hard {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int index=0,flag=1,len = intervals.length;
        if(newInterval[0]<=intervals[0][0])//在最左边
        {
            int left = newInterval[0];
            int right = newInterval[1];
            if (intervals[0][0] <= right)//可以合
            {
                right = Math.max(intervals[0][1], newInterval[1]);
                index = 0;
                while (index + 1 < len && intervals[index + 1][0] <= right) {
                    right = Math.max(intervals[index + 1][1], right);
                    index++;
                }
                res.add(new int[]{left, right});
                index++;
                while (index < len) {
                    left = intervals[index][0];
                    right = intervals[index][1];
                    while (index + 1 < len && intervals[index + 1][0] <= right) {
                        right = Math.max(intervals[index + 1][1], right);
                        index++;
                    }
                    res.add(new int[]{left, right});
                    index++;
                }
            } else {
                res.add(new int[]{left, right});
                index = 0;
                while (index < len) {
                    left = intervals[index][0];
                    right = intervals[index][1];
                    while (index + 1 < len && intervals[index + 1][0] <= right) {
                        right = Math.max(intervals[index + 1][1], right);
                        index++;
                    }
                    res.add(new int[]{left, right});
                    index++;
                }
            }
        }
        //在中间的话
        else{
            while (index < len) {
                int left = intervals[index][0];
                int right = intervals[index][1];
                while (index + 1 < len && intervals[index + 1][0] <= right) {
                    right = Math.max(intervals[index + 1][1], right);
                    index++;
                }
                res.add(new int[]{left, right});
                index++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
