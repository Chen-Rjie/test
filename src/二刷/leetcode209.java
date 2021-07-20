package 二刷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Chen
 * 2021/6/28 23:38
 */
public class leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left=0,right=0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int flag = 0;
        while(right<n){
            if(sum<target){
                sum += nums[right];
                right++;
            }
            else if(sum==target){
                flag = 1;
                res = Math.min(res,right-left);
                right++;
            }
            else{
                sum -= nums[left];
                left++;
            }
        }
        return flag==0?0:res;
    }

    public static void main(String[] args) {
        int target = 4;
        int[] nums = {1,4,4};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
//        int[] ts = list.toArray(new int[]);
        int[] ts = list.stream().mapToInt(Integer::valueOf).toArray();
        List<Integer> ts2 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int res =new leetcode209().minSubArrayLen(target,nums);
        System.out.println(res);
    }
}
