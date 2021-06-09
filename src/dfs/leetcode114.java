package dfs;


/**
 * Created by Chen
 * 2021/6/9 21:56
 */
//给你二叉树的根结点 root ，请你将它展开为一个单链表
public class leetcode114 {
    TreeNode pre = new TreeNode(0);
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        pre.right = root;
        pre.left = null;
        pre = root;
        flatten(left);
        flatten(right);
    }

}
