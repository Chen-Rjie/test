package com.company;
import java.util.*;
public class Solution_leetcode {
    class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> s = new Stack<>();
        List<List<Integer>> ls = new ArrayList<>();
        if(root==null)
            return ls;
        q.offer(root);
        while(!q.isEmpty())
        {
            List<Integer> tmp = new ArrayList<>();
            int sz = q.size();
            while (sz-->0)
            {
                TreeNode node = q.poll();
                tmp.add(node.val);
                if(node.left!=null)
                {
                    q.offer(node.left);
                }
                if(node.right!=null)
                {
                    q.offer(node.right);
                }
            }
            s.push(tmp);
        }
        while(!s.isEmpty())
        {
            ls.add(s.pop());
        }
        return ls;
    }
}
