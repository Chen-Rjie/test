package dp;
//最长回文子串
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
public class leetcode5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        String res = "";
        int tmplen = 0;
        for(int i=0;i<len;i++)
        {
            //i==0时候就是base case
            //变化量是长度 如同背包的容量
            for(int j=0;j<len;j++)
            {
                int k = j+i;
                if(k>=len)
                    break;;
                if(i==0)
                {
                    dp[j][k] = 1;
                    if(i+1>tmplen)
                    {
                        tmplen = i+1;
                        res = s.substring(j,k+1);
                    }
                }
                else if(i==1||i==2)
                {
                    if(s.charAt(j)==s.charAt(k))
                    {
                        dp[j][k] = 1;
                        if(i+1>tmplen)
                        {
                            tmplen = i+1;
                            res = s.substring(j,k+1);
                        }
                    }
                }
                else{
                    if(s.charAt(j)==s.charAt(k))
                    {
                        if(dp[j+1][k-1]==1)
                        {
                            dp[j][k]=1;
                            if(i+1>tmplen)
                            {
                                tmplen = i+1;
                                res = s.substring(j,k+1);
                            }
                        }

                    }
                }
            }
        }
        //第一步写出base case
        return res;

    }

    public static void main(String[] args) {
        String ts = "a";
        String res = new leetcode5().longestPalindrome(ts);
    }
}
