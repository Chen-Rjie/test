package 位运算;

public class leetcode169 {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums,0,nums.length-1);
    }
    int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    int majorityElementRec(int[] nums, int lo, int hi)
    {
        if(lo==hi)
            return nums[lo];
        int mid = lo +(hi-lo)/2;
        int left = majorityElementRec(nums,lo,mid);
        int right = majorityElementRec(nums,mid+1,hi);
        if(left==right)
            return left;
        int lcount = countInRange(nums,left,lo,hi);
        int rcount = countInRange(nums,right,lo,hi);
        return rcount>lcount?right:left;
    }
}
