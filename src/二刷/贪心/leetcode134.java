package 二刷.贪心;

/**
 * DATE: 2021/5/28
 * Author: (Chen)
 */
/*
加油站
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
 */
public class leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalRemain = 0,nowRemain=0;
        int pos = 0;
        for(int i=0;i< gas.length;i++){
            nowRemain += gas[i]-cost[i];
            if(nowRemain<0){
                pos = i+1;
                nowRemain = 0;
            }
            totalRemain += gas[i]-cost[i];

        }
        if(totalRemain<0)
            return -1;
        return pos;
    }
}
