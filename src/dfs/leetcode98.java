package dfs;

public class leetcode98 {
       class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
    public boolean isValidBST(TreeNode root) {
           int maxnum = Integer.MAX_VALUE;
           int minnum = Integer.MIN_VALUE;
           if(root.left==null||root.right==null)
               return false;
           return helper(root,minnum,maxnum);
    }
    public boolean helper(TreeNode root,Integer low,Integer high)
    {
        if(root==null)
        {
            return true;
        }
        int val = root.val;
        if(val<=low)
            return false;
        if(val>=high)
            return false;
        if(!helper(root.left,low,val))
            return false;
        if(!helper(root.right,val,high))
            return false;
        return true;
    }
}
