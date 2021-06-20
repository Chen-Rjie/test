package 二刷.DP;

import java.util.HashSet;

/**
 * Created by Chen
 * 2021/6/11 20:05
 */
public class leetcode_美团 {
    public int longestCommonString(String s1,String s2) {
        int maxLen = 0;
        int len1 = s1.length(),len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    maxLen = Math.max(maxLen,dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
//                new HashSet<Integer>();
//                String s = "sss".intern();
//                String b = "sss";
//                System.out.println(s==b);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "sss".intern();
        String b = "sss";
        System.out.println(s==b);
//        Integer m = 333;
//        Integer n = 333;
//        System.out.println(m==n);
        ts(b);
    }
    public static void ts(String tmp){
        String c = "sss";
        System.out.println(tmp==c);
    }
}
