package dfs;
import java.util.*;
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
public class leetcode39 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> line = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0,line,0);
        return res;
    }
    public void dfs(int[] candidates, int target,int sum,List<Integer> line,int index)
    {
        if(sum==target)
        {
            res.add(new ArrayList<>(line));
            return;
        }

        for(int i=index;i< candidates.length;i++)
        {
            sum += candidates[i];
            if(sum>target)
                return;
            line.add(candidates[i]);
            dfs(candidates,target,sum,line,i);
            sum -= candidates[i];
            line.remove(line.size()-1);

        }
    }
}
