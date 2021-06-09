package other;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//必须在原数组上操作，不能拷贝额外的数组。
//尽量减少操作次数。
public class leetcode283 {
    public void moveZeroes(int[] nums) {
        int start = 0,end = nums.length-1;
//        for(int i=start;i<=end;)
//        {
//            if(nums[i]!=0)
//            {
//                int tmp = nums[i];
//                nums[i] = nums[end];
//                nums[end] = tmp;
//                ++i;
//                ++start;
//            }
//            else {
//                int tmp = nums[i];
//                nums[i] = nums[end];
//                nums[end] = tmp;
//                --end;
//            }
//        }
        for(int i =0;i<end;i++)
        {
            if(nums[i]!=0)
            {
                int tmp = nums[i];
                nums[i] = nums[start];
                nums[start] = tmp;
                ++start;
            }

        }
    }
}
