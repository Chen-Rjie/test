package other;
//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
//
//        示例 1:
//
//        输入: [1,1,2,3,3,4,4,8,8]
//        输出: 2
public class leetcode540 {
    public int singleNonDuplicate(int[] nums) {
        int start = 0,end = nums.length-1;
        while (start<end)
        {
            int mid = (start+end)/2;
            if(nums[mid]==nums[mid+1])
            {
                if((mid-start+1)%2==0)
                    end = mid-1;
                else
                    start = mid;
            }
            else {
                //至少有3个数
                if(nums[mid-1]!=nums[mid])
                    return nums[mid];
                if((mid-start+1)%2==0)
                    start = mid+1;
                else
                    end = mid;
            }
        }
        return nums[start];
    }
}
