package dp;
/*
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
你找到的子数组应是最短的，请输出它的长度。
输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 */
public class leetcode581_array {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int[][] maxnum = new int[len][len];
        int[][] minnum = new int[len][len];
        for(int i=0;i<len;i++){
            int maxtmp = nums[i];
            int mintmp = maxtmp;
            maxnum[i][i] = maxtmp;
            minnum[i][i] = mintmp;
            for(int j=i+1;j<len;j++){
                maxtmp = Math.max(nums[j],maxtmp);
                maxnum[i][j] = maxtmp;
                mintmp = Math.min(nums[j],mintmp);
                minnum[i][j] = mintmp;
            }
        }

        return 1;
//        for(int i=0;i<len;i++){
////            for(int j=)
//        }
    }

}
