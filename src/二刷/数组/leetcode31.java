package 二刷.数组;

import java.util.Arrays;

/**
 * Created by Chen
 * 2021/6/29 18:30
 */
public class leetcode31 {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int pos = -1;
            for(int i=n-2;i>=0;i--){
                if(nums[i]<nums[i+1]){
                    pos = i+1;
                    break;
                }
            }
            if(pos!=-1){
                for(int i=n-1;i>=pos;i--){
                    if(nums[i]>nums[pos-1]){
                        int tmp = nums[i];
                        nums[i] = nums[pos-1];
                        nums[pos-1] = tmp;
                        break;
                    }
                }
            }
            Arrays.sort(nums,pos+1,n);
            return;
        }

    public static void main(String[] args) {
        int[] ts = {1,3,2};
        new leetcode31().nextPermutation(ts);
        System.out.println('1');
    }
}
