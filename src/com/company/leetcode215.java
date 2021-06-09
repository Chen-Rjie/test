package com.company;
import java.util.*;
public class leetcode215 {
    /*public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
        int pos = 0,len = nums.length;
        while (queue.size()<k)
        {
            queue.offer(nums[pos]);
            pos++;
        }
        while(pos<len)
        {
            if(nums[pos]>queue.peek())
            {
                queue.poll();
                queue.offer(nums[pos]);
            }
            pos++;
        }
        return queue.peek();
    }*/
    //快排的思想做
    public int findKthLargest(int[] nums, int k)
    {
        int len = nums.length;
        int par = perm(nums,0,len-1,k);
        return nums[par];

    }
    public int perm(int [] input,int start,int end,int k)
    {
        if(start==end)
            return start;
        int par = partition(input,start,end);
        if(par==k)
            return par;
        else if(k>par)
        {
            return perm(input,par+1,end,k);
        }
        else
        {
            return perm(input,start,par-1,k);
        }
    }
    public int partition(int[] array,int start,int end)
    {
        int base = array[start];
        while(start<end) {
            while (start < end && array[end] < base) {
                end--;
            }
            if (start < end) {
                array[start] = array[end];
                start++;
            }
            while (start < end && array[start] > base) {
                start++;
            }
            if (start < end) {
                array[end] = array[start];
                end--;
            }
        }
        array[start] = base;
        return start;
    }

}
