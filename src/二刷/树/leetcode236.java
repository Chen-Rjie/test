package 二刷.树;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * DATE: 2021/6/2
 * Author: (Chen)
 */
/*
二叉树的最近公共祖先
 */
public class leetcode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //当前节点和其中一个目标节点相等 而另一个节点一定在子节点中 那么该节点一定是公共祖先节点
        if(root==null)
            return null;
        if(root==q||root==p){
            return root;
        }
        else {
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            if(left!=null&&right!=null)
                return root;
            if(left==null){
                return right;
            }
            else
                return left;
        }
    }
}
