package dp;
/*
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
注意你可以重复使用字典中的单词。
 */
import java.util.*;
public class leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int[] dp = new int[len+1];
        Set<String> set = new HashSet<>();
        dp[0] = 1;
        int maxlen = 0;
        for(String str:wordDict){
            int now = str.length();
            maxlen = now>maxlen?now:maxlen;
            set.add(str);
        }
        for(int i=1;i<=len;i++){
            for(int j=0;j<maxlen;j++){
                int leftend = i-j-1;
                if(leftend<0)
                    break;
                if(dp[leftend]==1&&set.contains(s.substring(i-j-1,i))){
                    dp[i]=1;
                    break;
                }
            }
        }
        return dp[len]==1;
    }

    public static void main(String[] args) {
        String ts = "leetcode";
        String[] hh = {"leet","code"};
        List<String> s = new LinkedList<>(Arrays.asList(hh));
        new leetcode139().wordBreak(ts,s);
    }
}
