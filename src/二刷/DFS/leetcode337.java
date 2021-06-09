package 二刷.DFS;

import java.util.HashMap;
import java.util.Map;

/**
 * DATE: 2021/6/7
 * Author: (Chen)
 */
public class leetcode337 {
    int res = 0;
    Map<TreeNode,Integer> mem = new HashMap<>();
    public int rob(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        if(mem.containsKey(root))
            return mem.get(root);
        //不加记忆化  会超时
        int val = root.val;
        int sum = 0;
        //抢劫当前节点
        sum += val;
        if(root.left!=null){
            sum += dfs(root.left.left)+dfs(root.left.right);
        }
        if(root.right!=null)
            sum += dfs(root.right.left)+dfs(root.right.right);
        //不抢
        int newSum = 0;
        newSum += dfs(root.left)+dfs(root.right);
        mem.put(root,Math.max(sum,newSum));
        return Math.max(sum,newSum);
    }
}
