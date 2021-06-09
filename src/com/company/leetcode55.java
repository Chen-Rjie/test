package com.company;

public class leetcode55 {
    static class Solution {
        public void sortColors(int[] nums) {
            //双指针问题
            int start=0,end = nums.length-1;
            for(int i=0;i<=end;)
            {
                if(nums[i]==0)
                {
                    int tmp = nums[i];
                    nums[i] = nums[start];
                    nums[start] = tmp;
                    start++;
                    i++;
                }
                else if(nums[i]==2)
                {
                    int tmp = nums[i];
                    nums[i] = nums[end];
                    nums[end] = tmp;
                    end--;
                }
                else{
                    i++;
                }
            }

        }
    }
    public static void main(String args[])
    {
        int[] ts = {2,0,1};
        new Solution().sortColors(ts);
    }
}

