package Tree;

public class leetcode297_hard {
    StringBuilder s = new StringBuilder();
    public String serialize(TreeNode root) {
        if(root==null)
        {
            s.append("#!");
            return s.toString();
        }

        s.append(root.val);
        s.append('!');
        serialize(root.left);
        serialize(root.right);
        return s.toString();
    }

    // Decodes your encoded data to tree.
    int idx = 0;
    public TreeNode deserialize(String data) {
        String[] splits = data.split("!");
        return helper(splits);
    }
    public TreeNode helper(String[] strings)
    {
        if(!strings[idx].equals('#'))
        {
            TreeNode node = new TreeNode(Integer.parseInt(strings[idx]));
            idx++;
            node.left = helper(strings);
            node.right = helper(strings);
            return node;
        }
        idx++;
        return null;
    }
}
