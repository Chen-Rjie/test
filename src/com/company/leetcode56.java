package com.company;
import java.util.*;
public class leetcode56 {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> res= new ArrayList<>();
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            int i=0;
            while(i< intervals.length)
            {
                int left = intervals[i][0];
                int right = intervals[i][1];
                while(i< intervals.length-1&&intervals[i+1][0]<= right)
                {
                    right = Math.max(right,intervals[i+1][1]);
                    i++;
                }
                res.add(new int[]{left,right});
                i++;
            }
            return res.toArray(new int[0][]);
        }

    }
    public static void main(String[] args)
    {
        int[][] ts = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new Solution().merge(ts);

    }

}
