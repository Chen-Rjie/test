package dp;

public class leetcode198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+2];
        int res =0;
        for(int j=2;j< dp.length;++j)
        {
            dp[j] = nums[j-2]+dp[j-2];

        }
        for(int i=2;i< dp.length;++i)
        {
            if(dp[i]>res)
                res = dp[i];
        }
        return res;
    }
    public static void main(String[] a)
    {
        int[] ts = {2,1,1,2};
        new leetcode198().rob(ts);
    }
}
