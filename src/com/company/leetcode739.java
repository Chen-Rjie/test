package com.company;
import java.util.*;
public class leetcode739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int len = T.length;
        int[] res = new int[len];
        for(int i=0;i<len;i++)
        {
            while(!stack.isEmpty()&&T[i]>T[stack.peek()])
            {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args)
    {
        int[] test = {73,74,75,71,69,72,76,73};
        int[] res = new leetcode739().dailyTemperatures(test);

    }
}
