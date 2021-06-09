package dp;

import java.util.*;

public class leetcode514 {
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[key.length()][ring.length()];
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0;i<ring.length();i++){
            char ch = ring.charAt(i);
            if(map.containsKey(ch)){
                map.get(ch).add(i);
            }
            else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(ch,tmp);
            }
        }
        for(int i=0;i<key.length();i++){
            Arrays.fill(dp[i],0x3f3f3f);
        }

        int minnum = 10000;
        char first = key.charAt(0);
        //base case
        for(int pos:map.get(first)){
            //从0开始计算距离
            int num = Math.min(pos+1,ring.length()-pos+1);
            dp[0][pos] = num;

        }
        for(int i=1;i< key.length();i++)
        {
            char now = key.charAt(i);
            char pre = key.charAt(i-1);
            for(int pos:map.get(now)){
                int min= dp[i][pos],prepos=-1;
                for(int index: map.get(pre)){
                    int tmp = Math.min(Math.abs(pos-index),ring.length()-Math.abs(pos-index))+1;
                    //并不是上一个值到这个位置最小就是最小 而是dp[i-1][index]+tmp要最小
//                    if(tmp<min){
//                        min = tmp;
//                        prepos = index;
//                    }
                    dp[i][pos] = Math.min(dp[i-1][index]+tmp,dp[i][pos]);
                }
//                dp[i][pos] = dp[i-1][prepos]+min;
            }
        }
        return Arrays.stream(dp[key.length()-1]).min().getAsInt();

    }
    public static void main(String[] args) {
        String ts = "ababcab",key="acbaacba";
        int res = new leetcode514().findRotateSteps(ts,key);
    }
}
