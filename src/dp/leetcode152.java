package dp;
/*
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
 */
public class leetcode152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
//        int[] dpmax = new int[len];
//        int[] dpmin = new int[len];
//        dpmax[0] = nums[0];
//        dpmin[0] = nums[0];
        int dpmax=nums[0],dpmin=nums[0];
        int maxnum = nums[0];
        for(int i=1;i<len;i++){
            int tmp = Math.max(Math.max(dpmax*nums[i],dpmin*nums[i]),nums[i]);
            maxnum = Math.max(tmp,maxnum);
            dpmin = Math.min(Math.min(dpmax*nums[i],dpmin*nums[i]),nums[i]);
            dpmax = tmp;
        }
        return maxnum;
    }


    /*
    public int maxProduct(int[] nums) {
        int a=1;
        int max=nums[0];

        for(int num:nums){
            a=a*num;
            if(max<a)max=a;
            if(num==0)a=1;

        }
        a=1;
        for(int i=nums.length-1;i>=0;i--){
            a=a*nums[i];
            if(max<a)max=a;
            if(nums[i]==0)a=1;
        }
        return max;
    }
     */

    public static void main(String[] args) {
        int[] ts = {-4,-3,-2};
        new leetcode152().maxProduct(ts);
    }
}
