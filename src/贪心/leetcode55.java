package 贪心;

public class leetcode55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int canright = 0;
        //canright记录当前位置i前面所有节点能到达的最远
        for(int i=0;i<n;i++)
        {
            if(i<=canright)
            {
                canright = Math.max(i+nums[i],canright);//为下一个节点更新一下
                if(canright>=n-1)
                    return true;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
