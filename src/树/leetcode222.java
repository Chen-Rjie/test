package 树;
/*
给出一个完全二叉树，求出该树的节点个数。

说明：

完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
public class leetcode222 {
    int count = 0,maxlevel = 0 ,flag=0;
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root,1);
        if(flag==1)
            count += Math.pow(2,maxlevel-1)-1;
        else
            count = (int)Math.pow(2,maxlevel)-1;
        return count;
    }
    public void dfs(TreeNode root,int level){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            if(level>=maxlevel){
                ++count;
                maxlevel = level;
            }
            else {
                flag=1;
                return;
            }
        }
        else if(root.left==null){
            if(level+1>=maxlevel){
                maxlevel = level+1;
            }
            count += 1;
            flag=1;
            return;
        }
        else if(root.right==null){
            if(level+1>=maxlevel){
                maxlevel = level+1;
            }
            count += 1;
            flag=1;
            return;
        }
//        else {
//            count += Math.pow(2,level)-1;
//            return;
//        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
    public void test222() {
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
//                new TreeNode(3, new TreeNode(6), null));
        TreeNode root = new TreeNode(1, new TreeNode(2),null);
        System.out.println(countNodes(root));
    }
    public static void main(String[] args) {
        new leetcode222().test222();
    }
}
