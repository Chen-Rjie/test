package 二刷.单调栈;

/**
 * DATE: 2021/5/29
 * Author: (Chen)
 */
/*
给定长度分别为m和n的两个数组，其元素由0-9构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n)个数字拼接成一个新的数，要
求从同一个数组中取出的数字保持其在原数组中的相对顺序。
求满足该条件的最大数。结果返回一个表示该最大数的长度为k的数组。输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]
//和移除k个数字求最大值一样 使用单调栈
 */
public class leetcode321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxSubsequence = new int[k];
        //考虑第一个数组中可选择数字的最小值和最大值
        int start = Math.max(k - n, 0), end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            if (k - i < 0)
                continue;
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            if (compare(curMaxSubsequence,0, maxSubsequence,0)>0) {
                System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
            }

        }
        return maxSubsequence;
    }
    public int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int remain = length-k;
        int[] stack = new int[k];
        int top = -1;//栈空
        for(int i=0;i<length;i++){
            while (top>=0&&remain>0&&stack[top]<nums[i]){
                top--;
                remain--;
            }
            if(top<k-1){
                stack[++top] = nums[i];
            }
            else {
                remain--;//删除栈外面比栈顶元素小的值
            }
        }
        return stack;
    }
    public int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int newIndex = 0, index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }
public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
    int x = subsequence1.length, y = subsequence2.length;
    while (index1 < x && index2 < y) {
        int difference = subsequence1[index1] - subsequence2[index2];
        if (difference != 0) {
            return difference;
        }
        index1++;
        index2++;
    }
    return (x - index1) - (y - index2);
}

    public static void main(String[] args) {
        int[] arr1 = {2,5,6,4,4,0};
        int[] arr2 = {7,3,8,0,6,5,7,6,2};
        int ts = 15;
        int[] res = new leetcode321().maxNumber(arr1,arr2,ts);
        System.out.println("  --   ");
    }

}
