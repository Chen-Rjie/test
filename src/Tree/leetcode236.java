package Tree;
//这种自定向下的都是左右根
public class leetcode236 {
//    TreeNode res = null;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        ownnode(root,p,q);
//        return res;
//    }
    /*public boolean ownnode(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null)
            return false;
        boolean lson = ownnode(root.left,p,q);
        boolean rson = ownnode(root.right,p,q);
        if((lson&&rson)||((root.val==p.val||root.val==q.val)&&(lson||rson)))
        {
//            if(res==null)
//                res = root;
//            return true;
            res = root;
        }
        return lson||rson||root.val==p.val||root.val== q.val;
    }*/

    //在左子树何右字数里面找p，q，找到的话就返回左子树或者右子树的根节点
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null)
            return null;
        if(root==p||root==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null)
            return root;
        else if(left==null)
            return right;
        else
            return left;
    }
}
