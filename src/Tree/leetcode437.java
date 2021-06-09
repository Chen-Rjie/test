package Tree;
import java.util.*;
public class leetcode437 {
    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }
    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> prefixCount = new HashMap<>();
        prefixCount.put(0,1);
        return dfs(root,prefixCount,sum,0);
    }
    //从上到下以每个节点作为结束节点统计一次
    public int dfs(TreeNode root,Map<Integer,Integer> prefixCount,int target,int curSum)
    {
        if(root==null)
            return 0;
        int res = 0;
        curSum += root.val;
        res += prefixCount.getOrDefault(curSum-target,0);
        prefixCount.put(curSum,prefixCount.getOrDefault(curSum,0)+1);
        res += dfs(root.left,prefixCount,target,curSum);
        res += dfs(root.right,prefixCount,target,curSum);
        //回溯
        prefixCount.put(curSum,prefixCount.get(curSum)-1);
        return res;

    }
}
