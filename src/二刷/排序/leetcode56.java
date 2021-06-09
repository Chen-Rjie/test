package 二刷.排序;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * DATE: 2021/5/29
 * Author: (Chen)
 */
/*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，
该数组需恰好覆盖输入中的所有区间
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class leetcode56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        ArrayList<int[]> arrayList = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for(int i=0;i<n;){
            int left = intervals[i][0];
            int rightMax = intervals[i][1];
            while (i+1<n&&intervals[i+1][0]<=rightMax){
                rightMax = Math.max(rightMax,intervals[i+1][1]);
                i++;
            }
            i++;
            arrayList.add(new int[]{left,rightMax});

        }
        return arrayList.toArray(new int[0][]);
    }
}
