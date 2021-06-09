package com.company;
import  java.util.*;



public class leetcode94 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()||root!=null)
        {
            while (root!=null)
            {
                stack.push(root);
                root = root.left;
            }
            TreeNode now = stack.pop();
            res.add(now.val);
            root = now.right;
        }
        return res;

    }
}
