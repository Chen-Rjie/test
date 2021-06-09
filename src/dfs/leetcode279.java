package dfs;
import java.util.*;
import java.util.Arrays;

public class leetcode279 {
    //dp做法
//    public int numSquares(int n) {
//        int[] dp = new int[n+1];
//        Arrays.fill(dp,Integer.MAX_VALUE);
//        dp[0] = 0;
//        int maxiter = (int)Math.sqrt(n);
//        int[] sqnums = new int[maxiter+1];
//        for(int i=1;i<=maxiter;i++)
//        {
//            sqnums[i] = i*i;
//        }
//        for(int i=1;i<=n;i++)
//        {
//            for(int k=1;k<=maxiter;k++)
//            {
//                if(i<sqnums[k])
//                    break;
//                dp[i] = Math.min(dp[i-sqnums[k]]+1,dp[i]);
//            }
//        }
//        return dp[n];
//    }

    //贪心
//    Set<Integer> square_nums = new HashSet<Integer>();
//    public boolean CanDivided(int n,int count)
//    {
//        if(count==1)
//            return square_nums.contains(n);
//        for(int sqrtnum : square_nums)
//        {
//            if(CanDivided(n-sqrtnum,count-1))
//                return true;
//        }
//        return false;
//    }
//    public int numSquares(int n) {
//        square_nums.clear();
//        int maxiter = (int)(Math.sqrt(n));
//        for(int i=1;i<=maxiter;++i)
//        {
//            square_nums.add(i*i);
//        }
//        int count = 1;
//        while (count<=n)
//        {
//            if(CanDivided(n,count))
//                return count;
//            count++;
//        }
//        return count;
//    }


    //BFS
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int level = 0;
        while (!queue.isEmpty())
        {
            ++level;
            int sz = queue.size();
            while (sz-->0)
            {
                int now = queue.poll();
                for(int i=1;i*i<=now;i++)
                {
                    int next = now-i*i;
                    if(next==0)
                        return level;
                    if(!visited.contains(next))
                        queue.offer(next);
                    visited.add(next);
                }

            }
        }
        return level;
    }

}
