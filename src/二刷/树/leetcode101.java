package 二刷.树;

import java.util.Stack;

/**
 * DATE: 2021/6/1
 * Author: (Chen)
 */
/*
对称二叉树
 */
public class leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root);
        while (!stack1.isEmpty()){
            TreeNode now1 = stack1.pop();
            TreeNode now2 = stack2.pop();
            if(now1==null&&now2==null)
                continue;
            if(now1==null||now2==null)
                return false;
            if(now1.val!=now2.val)
                return false;
            stack1.push(now1.right);
            stack1.push(now1.left);
            stack2.push(now2.left);
            stack2.push(now2.right);

        }
        return true;
    }
}
