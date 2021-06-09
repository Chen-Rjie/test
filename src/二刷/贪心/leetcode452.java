package 二刷.贪心;

import java.util.Arrays;

/**
 * DATE: 2021/5/28
 * Author: (Chen)
 */
/*
用最少的数量引爆气球
 */
public class leetcode452 {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n==0)
            return 0;
        Arrays.sort(points,(a,b)->a[1]-b[1]);
        int count = 1;
        int pos = points[0][1];
        for(int i=1;i<n;i++){
            if(points[i][0]>pos){
                count++;
                pos = points[i][1];
            }
        }
        return count;
    }
}
