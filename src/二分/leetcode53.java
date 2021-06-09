package 二分;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
/*
输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
//二分
public class leetcode53 {
    public int maxSubArray(int[] nums) {
        int[] res = bin_max(nums,0,nums.length-1);
        return res[3];
    }
    public int[] bin_max(int[] nums,int l,int r){
        if(l==r){
            return new int[]{nums[l],nums[l],nums[l],nums[l]};
        }
        int mid = (l+r)/2;
        int[] left = bin_max(nums,l,mid);
        int[] right = bin_max(nums,mid+1,r);
        int[] sum = merge(left,right);
        return sum;
    }
    public int[] merge(int[] left,int[] right){
        int sum = left[0]+right[0];
        int lmax = Math.max(left[1],left[0]+right[1]);
        int rmax = Math.max(right[2],right[0]+left[2]);
        int maxsum = Math.max(Math.max(left[3],right[3]),left[2]+right[1]);
        return new int[]{sum,lmax,rmax,maxsum};
    }

    public static void main(String[] args) {
        int[] ts =new int[]{-2,1,-3,4,-1,2,1,-5,4};
        new leetcode53().maxSubArray(ts);
    }
}
