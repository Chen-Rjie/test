package dp;
//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//        给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
//        题目数据保证答案肯定是一个 32 位的整数。
public class leetcode91 {
    public int numDecodings(String s) {
        int len = s.length();
        if(len==0||s.charAt(0)=='0')
            return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i=1;i<len;i++)
        {
            if(s.charAt(i)=='0')
            {
                if(s.charAt(i-1)>'0'&&s.charAt(i-1)<'3')
                {
                    if(i-2<0)
                    {
                        dp[i] = 1;
                    }
                    else
                        dp[i] = dp[i-2];
                }
            }
            else if(s.charAt(i)>'0'&&s.charAt(i)<'7')
            {
                if(s.charAt(i-1)>'2'||s.charAt(i-1)=='0')
                {
                    dp[i] = dp[i-1];
                }
                else
                {
                    if(i-2>=0)
                    {
                        dp[i] = dp[i-1]+dp[i-2];
                    }
                    else
                        dp[i] = dp[i-1]+1;

                }
            }
            else {
                if(s.charAt(i-1)=='1')
                {
                    if(i-2>=0)
                    {
                        dp[i] = dp[i-1]+dp[i-2];
                    }
                    else
                        dp[i] = dp[i-1]+1;
                }
                else {
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        String ts = "10";
        int res = new leetcode91().numDecodings(ts);
    }
}
