package com.company;
import java.util.ArrayList;
public class mutiply {

    public static class Solution {
        public int[] multiply(int[] A) {
            int len = A.length;
            int[] B = new int[len];
            int[] C = new int[len];
            int[] D = new int[len];
            int res = 1;
            for(int i=0;i<len;i++)
            {
                C[i] = A[i]*res;
                res = C[i];
            }
            res = 1;
            for(int i=0;i<len;i++)
            {
                D[len-1-i] = A[i]*res;
                res = D[len-1-i];
            }
            for(int i=0;i<len;i++)
            {
                if(i==0)
                {
                    B[i] = D[i+1];
                }
                else if(i==len-1)
                {
                    B[i] = C[i-1];
                }
                else
                {
                    B[i] = C[i-1]*D[i+1];
                }
            }
            return B;
        }
    }
    public static void main(String[] args)
    {
        int[] test = {1,2,3,4,5,2,1};
        int[] res = new Solution().multiply(test);
        System.out.println(res);
    }
}
