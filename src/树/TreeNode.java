package 树;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x,TreeNode left, TreeNode right){
        val =x;
        this.left = left;
        this.right = right;
    }
}
