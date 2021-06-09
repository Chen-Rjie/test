package com.company;

public class mid {
    static class  Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length,len2 = nums2.length;
            int totallen = len1+len2;
            double res;
            if(totallen%2==1)
            {
                int mid = totallen/2;
                res = getKelement(nums1,nums2,mid+1);
            }
            else{
                int mid = totallen/2;
                res = (getKelement(nums1,nums2,mid)+getKelement(nums1,nums2,mid+1))/2.0;
            }
            return res;
        }
        public int getKelement(int[] nums1, int[] nums2,int k)
        {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int index1=0,index2=0;
            while(true)
            {
                if(index1==len1)
                {
                    return nums2[index2+k-1];
                }
                if(index2==len2)
                {
                    return nums1[index1+k-1];
                }
                if(k==1)
                {
                    return Math.min(nums1[index1],nums2[index2]);
                }


                int half = k/2;
                int newIndex1 = Math.min(index1+half-1,len1-1);
                int newIndex2 = Math.min(index2+half-1,len2-1);
                if(nums1[newIndex1]<nums2[newIndex2])
                {
                    k -= (newIndex1-index1+1);
                    index1 = newIndex1+1;
                }
                else
                {
                    k -= (newIndex2-index2+1);
                    index2 = newIndex2+1;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        int[] test1 = {1,2};
        int[] test2 = {3,4};
        double res = new Solution().findMedianSortedArrays(test1,test2);
        System.out.println(res);
    }
}
