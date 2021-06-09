package other;
//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
public class leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        //双向遍历
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len-1] = 1;
        int res = 1;
        for(int i=1;i<len;++i)
        {
            left[i] = res*nums[i-1];
            res = left[i];
        }
        res = 1;
        for(int i=len-2;i>=0;--i)
        {
            right[i] = nums[i+1]*res;
            res = right[i];
        }
        for(int i=0;i<len;i++)
        {
            left[i] = left[i]*right[i];
        }
        return left;
    }
    //节约一个数组空间
    /*
    class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }
}
     */

}
