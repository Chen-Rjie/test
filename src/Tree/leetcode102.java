package Tree;
import java.util.*;

public  class leetcode102 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null)
            return res;
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int sz = queue.size();
            List<Integer> level = new LinkedList<>();
            while (sz-->0)
            {

                TreeNode now = queue.poll();
                level.add(now.val);
                if(now.left!=null)
                {
                    queue.offer(now.left);
                }
                if(now.right!=null)
                {
                    queue.offer(now.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}