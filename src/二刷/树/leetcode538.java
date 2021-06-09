package 二刷.树;

/**
 * DATE: 2021/6/4
 * Author: (Chen)
 */
/*
把二叉搜索树转换为累加树
 */
public class leetcode538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
