package 二刷.树;

/**
 * Created by Chen
 * 2021/6/19 21:09
 */
public class leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
