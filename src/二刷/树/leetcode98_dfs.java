package 二刷.树;

import 二刷.堆.ListNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * DATE: 2021/6/1
 * Author: (Chen)
 */
/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 */
public class leetcode98_dfs {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        //中序遍历的做法
        boolean left = isValidBST(root.left);
        if(!left)
            return false;
        if(pre==null)
            pre = new TreeNode(root.val);
        else if(pre.val>= root.val)
            return false;
        pre.val = root.val;
        boolean right = isValidBST(root.right);
        return right;
    }
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (stack!=null||root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode now = stack.pop();
            if(now.val<=pre){
                return false;
            }
            pre = now.val;
            root = root.right;
        }
        String res = "  ";
        int[] a = {1};
//        new ArrayList<>()
//         s  = Arrays.asList(a);
//        new ArrayList<Integer>(a);
//        new LinkedList<Inte>(a);
        res.split(" ");
        return true;


    }
}
