package 二刷.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chen
 * 2021/6/28 21:21
 */
public class leetcode518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=1;i<=amount;i++){
            int count= 0;
            for(int j=0;j<coins.length;j++){
                int remain = i-coins[j];
                if(remain>=0){
                    count += dp[remain];
                }
            }
            dp[i] = count;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        int res = new leetcode518().change(amount,coins);
        System.out.println(res);
        Map<Integer, List<String>> map = new HashMap<>();
        map.values();
//        map.put(1,map.getOrDefault(1,new ArrayList<String>()).add("str"));
    }
}
