package 二分;
//给你一个升序排列的整数数组 nums ，和一个整数 target 。
//
//        假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
//
//        请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//自己写的又臭又长的代码
public class leetcode33 {
    //看到这种明显线性复杂度的就想到二分
    public int search(int[] nums, int target) {
        int len = nums.length;
        int start = 0,end = len-1;
        while (start<end){
            int mid = (start+end)/2;
            if(nums[start]==target)
                return start;
            if(nums[end]==target)
                return end;
            if(nums[mid]==target)
                return mid;
            else if(target>nums[mid]){
                if(mid==end)
                    return -1;
                else if(nums[end]>nums[mid])//右边是有序的
                {
                    if(nums[end]>target)
                    {
                        end =end-1;
                        start = mid+1;
                    }
                    else {
                        end = mid -1;
                    }
                }
                else {
                    start = mid+1;
                }
            }
            else{//情况比较多
                 if(mid==start)
                 {
                     return -1;
                 }
                 else if(nums[start]<nums[mid])//mid左边是有序的
                 {
                     if(nums[start]<target)//只可能存在于mid左边
                     {
                         start = start+1;
                         end = mid -1;
                     }
                     else {
                         start = mid+1;
                     }
                 }
                 else{
                     end = mid -1;
                 }
            }
        }
        return nums[start]==target?start:-1;
    }

    public static void main(String[] args) {
        int[] ts = {8,9,2,3,4};
        int target = 9;
        int res = new leetcode33().search(ts,target);
    }
}
