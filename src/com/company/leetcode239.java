package com.company;
import java.util.*;
public class leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();//存放下标
        int len = nums.length,count=0;
        int[] res = new int[len-k+1];
        for(int i=0;i<nums.length;i++)
        {
            while(!deque.isEmpty()&&nums[i]>nums[deque.peekLast()])
            {
                deque.pollLast();
            }
            deque.offerLast(i);
            if(deque.peekFirst()+k<=i)
            {
                deque.pollFirst();
            }
            if(i>=k-1)
            {
                res[count++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
