package 二刷.树;

import java.util.HashMap;
import java.util.Map;

/**
 * DATE: 2021/6/1
 * Author: (Chen)
 */
/*
给定一个二叉树，它的每个结点都存放着一个整数值。
找出路径和等于给定数值的路径总数。
路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 */
public class leetcode437 {
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        helper(root,0,targetSum,map);
        return res;
    }
    public void helper(TreeNode root, int sum,int targetSum,Map<Integer,Integer> map) {
        if(root==null)
            return;
        sum += root.val;
        map.put(sum,map.getOrDefault(sum,0)+1);
        res += map.getOrDefault(sum-targetSum,0);
        helper(root.left,sum,targetSum,map);
        helper(root.right,sum,targetSum,map);
        map.put(sum,map.getOrDefault(sum,0)-1);
    }
}
