package dfs;
import java.util.*;
public class leetcode46 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> line = new LinkedList<>();
//    int[] visited;
//    public List<List<Integer>> permute(int[] nums) {
//        visited = new int[nums.length];
//        dfs(nums,0);
//        return res;
//    }
//    public void dfs(int[] nums,int level)
//    {
//        if(level== nums.length)
//            res.add(new ArrayList<>(line));
//        for(int i=0;i< nums.length;i++)
//        {
//            if(visited[i]==0)
//            {
//                line.add(nums[i]);
//                visited[i] = 1;
//                dfs(nums,level+1);
//                visited[i] = 0;
//                line.remove(line.size()-1);
//            }
//        }
//
//    }


    //swap做法 动态规划思想
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }
    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first)
    {
        if(first==n)
            res.add(new ArrayList<>(output));
        for(int i=first;i<n;i++)
        {
            Collections.swap(output,first,i);
            backtrack(n,output,res,first+1);
            Collections.swap(output,first,i);
        }
    }
}
