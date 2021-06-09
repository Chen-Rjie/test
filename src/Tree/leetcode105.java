package Tree;

public class leetcode105 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0, preorder.length-1,inorder,0, preorder.length-1);
    }
    public TreeNode helper(int[] preorder,int start1,int end1,int[] inorder,int start2,int end2)
    {
        if(start1>end1)
            return null;
        TreeNode root = new TreeNode(preorder[start1]);
        int index = start2;
        while (index<=end2)
        {
            if(inorder[index]== root.val)
                break;
        }
        int leftlen = index-start2;
        int rightlen = end2-index;
        root.left = helper(preorder,start1+1,start1+leftlen,inorder,start2,start2+leftlen-1);
        root.right = helper(preorder,start1+leftlen+1,start1+leftlen+rightlen,inorder,start2+leftlen+1,start2+leftlen+rightlen);
        return root;
    }
}
