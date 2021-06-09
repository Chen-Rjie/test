package 位运算;
import java.util.*;
public class leetcode78 {
    //首先想到dfs的解法
//    List<List<Integer>> res = new LinkedList<>();
//    public List<List<Integer>> subsets(int[] nums) {
//        List<Integer> line = new ArrayList<>();
//        dfs(nums,0,nums.length,line);
//        return res;
//    }
//    public void dfs(int[] nums,int now,int len,List<Integer> line)
//    {
//        if(now==len)
//        {
//            res.add(new ArrayList<>(line));
//            return;
//        }
//        line.add(nums[now]);
//        dfs(nums,now+1,len,line);
//        line.remove(line.size()-1);
//        dfs(nums,now+1,len,line);
//    }

    //位运算解法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  res = new ArrayList<>();
//        int maxiter = bit2num(nums.length);
        int tmp;
        for(int i=0;i<(1<< nums.length);++i)
        {
            List<Integer> sub = new ArrayList<Integer>();
            for(int j=0;j<nums.length;j++)
            {
                if(((i>>j)&1)==1)
                    sub.add(nums[j]);
            }
            res.add(sub);
        }

        return res;
    }
//    public int bit2num(int len)
//    {
//        int res = 0,start=1,base=1;
//        while(start<=len)
//        {
//            res += base;
//            base *= 2;
//            start++;
//        }
//        return res;
//    }
}
