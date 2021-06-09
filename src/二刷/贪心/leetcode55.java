package 二刷.贪心;

/**
 * DATE: 2021/5/28
 * Author: (Chen)
 */
/*
跳跃游戏
输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 */
public class leetcode55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[]  jump = new int[n];
        jump[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            int nowstep = nums[i];
            for(int j=1;j<=nowstep;j++){
                int nextpos = j+i;
//                if(nextpos>=n)
//                    break;
                if(jump[nextpos]==1){
                    jump[i] = 1;
                    break;
                }
            }
        }
        return jump[0]==1;
    }

    //贪心

    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int maxRight = 0;
        for(int i=0;i<=maxRight;i++){
            maxRight = Math.max(maxRight,i+nums[i]);
            if(maxRight>=n-1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ts = {2,0};
        boolean res = new leetcode55().canJump(ts);
        System.out.println(res);
    }
}
