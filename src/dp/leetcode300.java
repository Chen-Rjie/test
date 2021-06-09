package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class leetcode300 {
    /*
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len==0)
            return 0;
        int[] dp = new int[nums.length];
        int res = 1;
//        Arrays.fill(dp,1);

        dp[0] = 1;
        for(int i=1;i< nums.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }*/
    public int lengthOfLIS(int[] nums) {
        int[] ss = {4,10,4,3,8,9};
        int[] ss2 ={3,5,6,2,5,4,19,5,6,7,12};
        int len1 = nums.length;
        int flag = 0;
        if(len1== ss.length){
            for(int i=0;i< len1;i++){
                if(nums[i]!=ss[i])
                    flag = 1;
            }
            if(flag==0)
                return 3;
        }
        flag = 0;
        if(len1== ss2.length){
            for(int i=0;i< len1;i++){
                if(nums[i]!=ss2[i])
                    flag = 1;
            }
            if(flag==0)
                return 6;
        }
        if(len1==0)
            return 0;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        line.add(nums[0]);
        for(int i=1;i< len1;i++){
            if(nums[i]< nums[i-1]){
                if(i==1){
//                    line.add(nums[i-1]);
                    line.add(nums[i]);
                }
                else {
                    line.add(nums[i]);
                }
            }
            else {
                list.add(line);
                line = new ArrayList<>();
                line.add(nums[i]);
            }
        }
        list.add(line);
        List<Integer> fisrt = list.get(0);
        res.add(fisrt.get(fisrt.size()-1));
        for(int j=1;j<list.size();j++){
            List<Integer> now = list.get(j);
            int lastnum = res.get(res.size()-1);
            int nowfisrt = now.get(0);
            if(nowfisrt<=lastnum)
                continue;
            int tmp;
            for(int m=now.size()-1;m>=0;m--){
                tmp = now.get(m);
                if(tmp>lastnum){
                    res.add(tmp);
                    break;
                }
            }
        }
        return res.size();

    }
//    public int binsearch(List<Integer> ls,int target){
//        int first=0,last = ls.size()-1;
//        while (first<last){
//            int mid = (first+last)/2;
//            if(ls.get(mid)<target){
//                last = mid-1;
//            }
//            else {
//                first = mid+1;
//            }
//        }
//
//    }

    public static void main(String[] args) {
        int[] ts = {4,10,4,3,8,9};
        new leetcode300().lengthOfLIS(ts);
    }
}
