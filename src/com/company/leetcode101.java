package com.company;
//牛客原题 对称二叉树

public class leetcode101 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    public boolean isSymmetric(TreeNode root) {
        return visit(root,root);
    }
    }
    public boolean visit(TreeNode node1,TreeNode node2)
    {
        if(node1==null&&node2==null)
            return true;
        if(node1==null||node2==null)
            return false;
        if(node1.val!=node2.val)
            return false;
        return visit(node1.left,node2.right)&&visit(node1.right,node2.left);
    }
}
