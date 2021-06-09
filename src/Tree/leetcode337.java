package Tree;
import java.util.*;
//记忆化搜索
public class leetcode337 {
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();


    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root);
        int res = Math.max(f.get(root),g.get(root));
        return res;
    }
    public void dfs(TreeNode root)
    {
        if(root==null)
            return;
        dfs(root.left);
        dfs(root.right);
        f.put(root,root.val+g.getOrDefault(root.left,0)+g.getOrDefault(root.right,0));
        g.put(root,Math.max(f.getOrDefault(root.left,0),g.getOrDefault(root.left,0))+Math.max(f.getOrDefault(root.right,0),g.getOrDefault(root.right,0)));
    }
}
