package 双指针;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
//
//        注意：答案中不可以包含重复的三元组。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/3sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
import java.util.*;
public class leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len;i++)
        {
            if(i!=0&&nums[i]==nums[i-1])
                continue;
            int target = -nums[i];
            int pos = len-1;
//            int lastpos = i+1;
            //每一层生成以该数打头的所有的元素
            for(int j=i+1;j<pos;)
            {
                if(j!=i+1&&nums[j]==nums[j-1])
                {
                    j++;
                    continue;
                }

                if(nums[j]+nums[pos]>target)
                    pos--;
                else if(nums[j]+nums[pos]<target)
                    j++;
                else
                {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[pos]);
                    res.add(tmp);
                    j++;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ts = new int[]{-1,0,1,2,-1,-4};
        List rs = new leetcode15().threeSum(ts);
    }
}
