package Tree;

public class leetcode129_dfs {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root, root.val);
        return res;
    }
    public void dfs(TreeNode root,int tmp)
    {
        if(root.left==null&&root.right==null)
        {
            res += tmp;
            return;
        }
        int nexttmp = 0;
        if(root.left!=null)
        {
            nexttmp = tmp*10 +root.left.val;
            dfs(root.left,nexttmp);
        }
        if(root.right!=null)
        {
            nexttmp  = tmp*10 +root.right.val;
            dfs(root.right,nexttmp);
        }
    }

    //广搜是每个节点存前缀和 两个队列
}
