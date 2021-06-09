package dfs;
//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//        '.' 匹配任意单个字符
//        '*' 匹配零个或多个前面的那一个元素
//        所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/regular-expression-matching
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class leetcode10_hard {
//    public boolean isMatch(String s, String p) {
//        int len1 = s.length(), len2 = p.length();
//        if(len1==0&&len2==0)
//            return true;
//        if(len1==0&&len2<=1)
//            return false;
//        if(len1==0&&p.charAt(1)=='*'&&len2==2)
//        {
//            return true;
//        }
//        return core(s,p,0,0);
//
//    }
//    public boolean core(String s,String p,int index1 ,int index2){
//        if(index1==s.length()&&index2==p.length()) //长了也不行
//            return true;
//        if(index1<s.length()&&index2==p.length())//短了也不行
//            return false;
//        if(index2+1<p.length()&&p.charAt(index2+1)=='*')
//        {
//            if(index1<s.length()&&(s.charAt(index1)==p.charAt(index2)||p.charAt(index2)=='.'))
//            {
//                return core(s,p,index1,index2+2)||core(s,p,index1+1,index2);//用来匹配和不用来匹配两种选择
//            }
//            else{
//                return core(s,p,index1,index2+2);
//            }
//        }
//        if(index1<s.length()&&(s.charAt(index1)==p.charAt(index2)||p.charAt(index2)=='.'))
//        {
//            return core(s,p,index1+1,index2+1);
//        }
//        else
//            return false;
//    }
//
//    public static void main(String[] args) {
//        String ts =  "aa",p = "a*";
//
//        boolean res = new leetcode10_hard().isMatch(ts,p);
//    }

    //dp 考虑到状态变换是用的两个String的下标
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1]; //这样写可以判断第一个字符串为空的情况
        //basecase
        dp[0][0] = true; //两个字符串都为空，写出一个base case i=0意思是s字符串为空的时候 j=0 直接就返回数组的默认值了也就是0
        for(int i=0;i<=s.length();i++)
        {
            for(int j=1;j<=p.length();j++)
            {
                if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2];
                    if(match(s,p,i,j-1))
                    {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
                else {
                    if(match(s,p,i,j))
                    {
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[s.length()+1][p.length()+1];
    }
    public boolean match(String s,String p,int i,int j)
    {
        if(i==0)
        {
            return false;//dp[0][?]=0
        }
        if(p.charAt(j-1)=='.')
            return true;
        if(s.charAt(i-1)==p.charAt(j-1))
            return true;
        return false;
    }
}
