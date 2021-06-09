package com.company;
import java.util.*;
public class leetcode42 {
    //暴力
//    public int trap(int[] height) {
//        //第一个位置可以接到的雨水判定涵盖在了height[i]==maxleft中，肯定最大与当前相等 也就是接的雨水为0
//        int maxleft = 0,maxright = 0;
//        int res = 0;
//        for(int i=0;i<height.length;i++)
//        {
//            if(height[i]>maxleft)
//                maxleft = height[i];
//            maxright = height[i];
//            for(int j=i+1;j< height.length;j++)
//            {
//                if(maxright<height[j])
//                    maxright = height[j];
//            }
//            res += Math.min(maxleft,maxright)-height[i];
//        }
//        return res;
//    }


    //栈 单调栈
//    public int trap(int[] height)
//    {
//        Stack<Integer> stack = new Stack<>();
//        int pos = 0,len = height.length,res=0;
//        while(pos<len)
//        {
//            while(!stack.isEmpty()&&height[pos]>height[stack.peek()])
//            {
//                int top = stack.peek();
//                stack.pop();
//                if(stack.isEmpty())
//                    break;
//                int dis = pos - stack.peek()-1;
//                res += dis*(Math.min(height[pos],height[stack.peek()])-height[top]);
//            }
//            stack.push(pos++);
//        }
//        return res;
//    }
    //双指针
    public int trap(int[] height)
    {
        int left = 0, right = height.length-1;
        int leftmax =0 ,rightmax =0,res=0;
        while(left<right)
        {
            if(height[left]<height[right])
            {
                if(height[left]>leftmax)
                {
                    leftmax = height[left];
                }
                else
                {
                    res += height[left]-leftmax;
                }
                left++;
            }
            else
            {
                if(height[right]>rightmax)
                {
                    rightmax = height[right];
                }
                else {
                    res += height[right]-rightmax;
                }
                right--;
            }
        }
        return res;
    }
}
