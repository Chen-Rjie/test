package Tree;

public class leetcode144 {
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
    //线索化二叉树
    TreeNode pre =null,proot= null;
    public void flatten(TreeNode root) {
        if(proot==null)
        {
            proot = root;
        }
        if(pre!=null)
        {
            pre.right = root;
            pre.left = null;
        }
        if(root==null)
            return;
        pre = root;
        flatten(root.left);
        flatten(root.right);
    }
}
