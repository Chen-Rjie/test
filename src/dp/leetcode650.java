package dp;

public class leetcode650 {
    int res;
    int[][] dp;
    public int minSteps(int n) {
        dp = new int[n+1][n+1];

        res = n;
        if(n==1)
            return 0;
        dfs(n,1,1,1);
        return res;
    }
    void dfs(int n,int level,int count,int lastcopy)
    {
        dp[1][1] = 1;
        if(count == n)
        {
//            if(level<res)
//            {
//                res = level;
//            }
            res = Math.min(res,level);
            return;
        }
        if(level>res)
            return;
        if(count>n)
            return;

//        lastcopy = count;
        dfs(n,level+1,count+lastcopy,lastcopy);//粘贴
        dfs(n,level+1,count,count);//复制

    }

    public static void main(String[] args) {
        int ts = 6;
        int res = new leetcode650().minSteps(ts);
        System.out.println(res);
    }
}
