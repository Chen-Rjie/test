package other;

public class leetcode53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i=1;i<len;i++)
        {
            if(dp[i-1]<0)
            {
                dp[i] = nums[i];
            }
            else
            {
                dp[i] = dp[i-1]+nums[i];
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
