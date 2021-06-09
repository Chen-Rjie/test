package 剑指offer;
import java.util.*;
public class mid_48 {
    //滑动窗口法
//    public int lengthOfLongestSubstring(String s) {
//        int start = -1,res=0;
//        Map<Character,Integer> map = new HashMap<>();
//        for(int i=0;i<s.length();++i)
//        {
//            char now = s.charAt(i);
//            if(map.containsKey(now))
//            {
//                start = Math.max(start,map.get(now));
//                //用来判断前当前滑动窗口的起始位置，越往右越能满足，要是以前一个为起始的话则必有重复
//            }
//            map.put(now,i);
//            res = Math.max(i-start,res);
//        }
//        return res;
//    }


    //动态规划 dp[j] = dp[j-1]+1
    //dp[j] = j-i
//    public int lengthOfLongestSubstring(String s) {
//        Map<Character,Integer> map = new HashMap<>();
//        int res=0,tmp=0;
//        int[] dp = new int[s.length()+1];
//        for(int j=1;j<=s.length();j++)
//        {
//            char now = s.charAt(j-1);
//            int sameindex = map.getOrDefault(now,-1);
//            if(sameindex<0)
//                dp[j] = dp[j-1]+1;
//            else {
//                if(dp[j-1]<j-sameindex)
//                    dp[j] = dp[j-1]+1;
//                else
//                    dp[j] = j-sameindex;
//            }
//            map.put(now,j);
//            res = Math.max(res,dp[j]);
//        }
//        return res;
//    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        //dp简化成tmp
        int res=0,tmp=0;
        for(int j=0;j<s.length();j++)
        {
            char now = s.charAt(j);
            int sameindex = map.getOrDefault(now,-1);
            if(sameindex<0)
                tmp = tmp+1;
            else {
                if(tmp<j-sameindex)
                    tmp = tmp+1;
                else
                    tmp = j-sameindex;
            }
            map.put(now,j);
            res = Math.max(res,tmp);
        }
        return res;
    }
}
