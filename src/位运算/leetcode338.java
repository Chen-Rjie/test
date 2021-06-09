package 位运算;

public class leetcode338 {
    //解法1
//    public int[] countBits(int num) {
//        int[] dp = new int[num+1];
//        dp[0] = 0;
//        for(int i=1;i<=num;i++)
//        {
//            dp[i] = dp[i&(i-1)]+1;
//        }
//        return dp;
//    }

    //解法2
//    public int[] countBits(int num) {
//        int[] dp = new int[num+1];
//        dp[0] = 0;
//        for(int i=1;i<=num;i++)
//        {
//            if((i&1)==1)
//            {
//                dp[i] = dp[i>>1]+1;
//            }
//            else {
//                dp[i] = dp[i>>1];
//            }
//        }
//        return dp;
//    }

    //解法3 P(x+b)=P(x)+1,b=pow(2,m) and b>x
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        int base = 1,i=0;
        while(base<=num)
        {
            while (i<base&&i+base<=num)
            {
                dp[i+base] = dp[i]+1;
                i++;
            }
            i = 0;
            base = base<<1;
        }
        return dp;
    }
}
