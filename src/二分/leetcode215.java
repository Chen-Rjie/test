package 二分;

/**
 * Created by Chen
 * 2021/6/19 17:24
 */
public class leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        int pos;
        while(left<right){
            // pos = (left+right)>>1;
            // if()
            pos = sort(nums,left,right);
            if(pos==k-1)
                return nums[pos];
            else if(pos>k-1){
                right = pos-1;
            }
            else{
                left = pos+1;
            }
        }
        return nums[left];
    }
    public int sort(int[] nums,int left,int right){
        int i=left,j=right;
        int base = nums[i];
        while(i<j){
            while(j>i&&nums[j]<base)
                j--;
            if(i<j){
                nums[i] = nums[j];
                i++;
            }
            while(i<j&&nums[i]>=base){
                i++;
            }
            if(i<j){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = base;
        return i;
    }
}
