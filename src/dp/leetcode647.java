package dp;

public class leetcode647 {
    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int count = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j+i<len;j++){
                if(i==0){
                    dp[j][j+i] = 1;
                    count++;
                }
                else if(i==1){
                    if(s.charAt(j)==s.charAt(j+1))
                    {
                        dp[j][j+i] = 1;
                        count++;
                    }
//                    else {
//                        dp[j][j+i] = 0;
//                    }

                }
                else {
                    if(s.charAt(j)==s.charAt(j+i)){
                        if(dp[j+1][j+i-1]==1)
                        {
                            dp[j][j+i] = dp[j+1][j+i-1];
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
