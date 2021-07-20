package 剑指offer;

/**
 * Created by Chen
 * 2021/7/5 20:37
 */
public class offer_14 {
    public static void main(String[] args) {
        int res =  new offer_14().cuttingRope(10);
        System.out.println(res);
    }
    public int cuttingRope(int n) {
        if(n<4)
            return n-1;
        int[] dp = new int[n+1];
        //略有不同的是绳子必须剪
        dp[0] = 0;
        //假设绳子不是不许剪
        if(n>=1)
            dp[1] = 1;
        if(n>=2)
            dp[2] = 2;
        if(n>=3)
            dp[3] = 3;
        for(int i=4;i<=n;i++){
            int maxRes = 0;
            for(int j=1;j<i;j++){
                int tmp = dp[j]*dp[i-j];
                if(tmp>maxRes){
                    maxRes = tmp;
                }
            }
            dp[i] = maxRes;
        }
        return dp[n];
    }
}
