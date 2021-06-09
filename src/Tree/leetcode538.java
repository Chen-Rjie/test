package Tree;
public class leetcode538 {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        bianli(root);
        return root;
    }
    public void bianli(TreeNode root)
    {
        if(root==null)
             return;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

    }
}
