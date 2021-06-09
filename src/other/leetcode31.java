package other;

import java.util.Arrays;

//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//        必须原地修改，只允许使用额外常数空间。
//
//        以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1
public class leetcode31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i=0,minindex = len-1;
        for(i=len-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                break;
            }
        }
        //从右往左找到第一个顺序对
        //从i+1开始数组是递减的了 否则不可能从i开始才有顺序对
        if(i>=0)
        {
            for(int j=len-1;j>=i+1;j--)
            {
                if(nums[j]>nums[i])
                {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }
        }
        //reverse //这里不用sort 交换完毕后还是逆序的
        for(int k = i+1,e=len-1;k<e;k++,e--)
        {
            int tmp = nums[k];
            nums[k] = nums[e];
            nums[e] = tmp;
        }
//        for(i=0;i<len-1;i++)
//        {
//            if(nums[i]<nums[i+1])
//            {
//                int tmp = nums[i];
//                nums[i] = nums[i+1];
//                nums[i+1] = tmp;
//                break;
//            }
//        }
        //Arrays.sort(nums,i+1,len);
    }

    public static void main(String[] args) {
        int[] ts = new int[]{1,3,2};
        new leetcode31().nextPermutation(ts);
        System.out.println("222");
    }
}
