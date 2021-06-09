package Tree;
public class leetcode124_hard {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //二叉树中的最大路径和
    int maxres = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxres;
    }
    public int helper(TreeNode root) {
        if(root==null)
            return 0;
        int left = Math.max(helper(root.left),0);
        int right = Math.max(helper(root.right),0);
        int low2high = Math.max(left,right)+ root.val;
        if(left+right+ root.val>maxres)
            maxres = left+right+ root.val;
        return low2high;
    }
}
