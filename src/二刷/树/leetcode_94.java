package 二刷.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
二叉树中序遍历
非递归后序遍历
 */
public class leetcode_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
//        stack.push(root);
        TreeNode pre = null;
        while(!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right==null||root.right==pre){
                list.add(root.val);
                pre = root;
                root = null;
            }else {
                root = root.right;
            }
//            if(pre!=root.right){
//                stack.push(root.right);
//            }
//            else {
//                list.add(root.val);
//                pre = root;
//                root =
//            }
        }
        return list;
    }
}
