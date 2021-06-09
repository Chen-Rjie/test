package 二分;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//        你的算法时间复杂度必须是 O(log n) 级别。
//
//        如果数组中不存在目标值，返回 [-1, -1]。
public class leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0]==target){
                return new int[]{0,0};
            }
            return new int[]{-1,-1};
        }
        int left = binsearchleft(nums,0,nums.length,target);
        int right = binsearchleft(nums,0,nums.length,target+1);
        if(left== nums.length||nums[left]!=target){
            return new int[]{-1,-1};
        }
        else
            return new int[]{left,right-1};
    }
    public int binsearchleft(int[] nums,int start,int end,int target){

        while (start<end){
            int mid = (start+end)/2;
            if(nums[mid]<target){
                start = mid+1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
    public int binsearchright(int[] nums,int start,int end,int target){
        while (start<end){
            int mid = (start+end)/2;
            if(nums[mid]>target){
                end = mid-1;
            }
            else {
                start = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] ts = new int[]{2,2};
        int num = 3;
        int[] res = new leetcode34().searchRange(ts,num);
    }
}
