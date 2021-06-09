package Tree;
//二叉树的最大深度
public class leetcode104 {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int lefthigh = maxDepth(root.left);
        int righthigh = maxDepth(root.right);
        return Math.max(lefthigh,righthigh)+1;
    }
}
