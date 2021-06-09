package 二分;
//给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
//        区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
//看到这个求区间和的肯定就想到前缀和
//问题可以转化为给定两个下标 求这两个下标前缀和的差在给定范围内的可能性总数 这样一看 这个题就类似与求逆序对总数那个题
import java.util.*;
public class leetcode327_hard {
//    int count = 0,sum=0;
//    int[] sums,tmp,tmp2;
//    public int countRangeSum(int[] nums, int lower, int upper) {
//        for (int j:nums){
//            if(j>=lower&&j<=upper){
//                count++;
//            }
//        }
//
//        sums = new int[nums.length];
//        tmp = new int[nums.length];
//        tmp2 = new int[nums.length];
//        for(int i=0;i<nums.length;i++)
//        {
//            sum += nums[i];
//            sums[i] = sum;
//        }
//        mergesort(nums,sums,0,nums.length-1,lower,upper);
//        return count;
//
//    }
//    public void mergesort(int[] num, int[] sums,int left, int right, int lower, int upper){
//        //先写递归出口
//        if(left==right)
//            return;
//        int mid = (left+right)/2;
//        mergesort(num,sums,left,mid,lower,upper);
//        mergesort(num,sums,mid+1,right,lower,upper);
//        int i = left,ll=mid+1,rr=mid+1;
//        while (i<=mid){
//            if(ll<=right&&sums[ll]-sums[i]+num[i]<lower){
//                ll++;
//            }
//            while (rr<=right&&sums[rr]-sums[i]+num[i]<=upper){
//                rr++;
//            }
//            count += rr-ll;
//            i++;
//        }
//        int froml = left,fromr=mid+1,from=left;
//        while (froml<=mid&&fromr<=right){
//            if(sums[froml]<sums[fromr]){
//                tmp2[from] = num[froml];
//                tmp[from++] = sums[froml++];
//            }
//            else {
//                tmp2[from] = num[fromr];
//                tmp[from++] = sums[fromr++];
//            }
//        }
//        while (froml<=mid){
//            tmp2[from] = num[froml];
//            tmp[from++] = sums[froml++];
//
//        }
//        while (fromr<=right){
//            tmp2[from] = num[fromr];
//            tmp[from++] = sums[fromr++];
//        }
//        for (int j=left;j<=right;j++){
//            sums[j] = tmp[j];
//            num[j] = tmp2[j];
//        }
//
//
//    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            sum[i + 1] = s;
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = (int) sum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = (int) sum[p1++];
                } else {
                    if (sum[p1] < sum[p2]) {
                        sorted[p++] = (int) sum[p1++];
                    } else {
                        sorted[p++] = (int) sum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int[] ts = {-2,5,-1};
        int lower = -2,upper = 2;
        int res = new leetcode327_hard().countRangeSum(ts,lower,upper);
    }
}
