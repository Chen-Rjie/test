package other;
//给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//
//        找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//
//        您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
import java.util.*;
public class leetcode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //hash
//        List<Integer> res = new LinkedList<>();
//
//        int[] hash = new int[nums.length+1];
//        for(int num :nums)
//        {
//            hash[num] = 1;
//        }
//        for(int i=0;i< nums.length;i++)
//        {
//            if(hash[nums[i]]==0)
//                res.add(nums[i]);
//        }
//        return res;

        //遍历每个元素，对索引进行标记
        //将对应索引位置的值变为负数；
        //遍历下索引，看看哪些索引位置上的数不是负数的。
        //位置上不是负数的索引，对应的元素就是不存在的
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len;i++)
        {
            int num = Math.abs(nums[i]);
            nums[num-1] *= -1;
        }
        for(int i=0;i<len;i++)
        {
            if(nums[i]>0)
            {
                res.add(i+1);
            }
        }
        return res;

    }
}
