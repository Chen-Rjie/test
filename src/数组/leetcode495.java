package 数组;
/*
输入: [1,4], 2
输出: 4
原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
所以最终输出 4 秒
 */
import java.util.*;
public class leetcode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int lentime = timeSeries.length;
        if(lentime==0)
            return 0;
        int res = 0;
        int[] endtime = new int[lentime];
        for(int i=0;i<lentime;i++){
            //endtime初 endtime-1末
            endtime[i] = timeSeries[i]+duration;
        }
        res = duration;
        for(int i=1;i<lentime;i++){
            if(timeSeries[i]<endtime[i-1]){
                res += endtime[i]-endtime[i-1];
//                res += duration-(endtime[i-1]-timeSeries[i]);
            }
            else {
                res +=duration;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ts = {1,2,3,4,5,6,7,8,9};
        int n = 1;
        int res = new leetcode495().findPoisonedDuration(ts,n);
    }

}
