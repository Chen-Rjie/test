package other;

public class leetcode209 {
    //滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0;
        int sum = 0, tmplen = 0, res = nums.length+1;
        int flag = 0;
        while (right <nums.length) {
            if (sum >= s) {
                while (sum >= s && left < right) {
                    res = Math.min(res, tmplen);
                    sum -= nums[left];
                    left++;
                    tmplen--;
                }
            } else {

                sum += nums[right];
                tmplen++;
                right++;
//                if(right< nums.length-1||flag==1)
//                {
//                    right++;
//                }
            }

        }
        if (sum >= s) {
            while (sum >= s && left < right) {
                res = Math.min(res, tmplen);
                sum -= nums[left];
                left++;
                tmplen--;
            }
        }
        if(res == nums.length+1)
            res = 0;
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] ts = new int[]{1,1};
        int res =new leetcode209().minSubArrayLen(n,ts);
    }
}
