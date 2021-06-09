package 二刷.贪心;

/**
 * DATE: 2021/5/29
 * Author: (Chen)
 */
/*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
假设你总是可以到达数组的最后一个位置。
输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
   从下标为 0 跳到下标为 1 的位置，跳步，然后跳步到达数组的最后一个位置。
 */
public class leetcode45 {
    public int jump(int[] nums) {
        //minStep存放该位置到最后一个位置所需的最小跳跃次数
        int n = nums.length;
        int[] minStep = new int[n];
        int[] canJump = new int[n];
        minStep[n-1] = 0;
        canJump[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            int maxStep = nums[i];
            int minTmp = n;
            for(int j=1;j<=maxStep&&i+j<n;j++){
                if(canJump[i+j]==1){
                    minTmp = Math.min(minTmp,minStep[i+j]+1);
                    canJump[i] = 1;
                }
            }
            minStep[i] = minTmp;
        }
        return minStep[0];
    }

    public static void main(String[] args) {
        int[] ts = {2,3,1,1,4};
        int res = new leetcode45().jump(ts);
        System.out.println(res);}
}
