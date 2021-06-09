package 二刷.树;

import java.util.HashMap;
import java.util.Map;

/**
 * DATE: 2021/6/4
 * Author: (Chen)
 */
/*
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
public class leetcode337 {
    Map<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
//        //记忆化搜索 两个map分别当前节点选和不选的最大值
//        Map<TreeNode,Integer> mapChoose = new HashMap<>();
//        Map<TreeNode,Integer> mapNoChoose = new HashMap<>();
        int res = tryRob(root);
        return res;
    }
    public int tryRob(TreeNode node){
        if(node==null)
            return 0;
        if(map.containsKey(node))
            return map.get(node);
        int res1 = node.val;
        if(node.left!=null){
            res1 += (tryRob(node.left.left)+tryRob(node.left.right));
        }
        if(node.right!=null){
            res1 += (tryRob(node.right.left)+tryRob(node.right.right));
        }
        int res2 = 0;
        res2 += tryRob(node.left)+tryRob(node.right);
        map.put(node,Math.max(res1,res2));
        return map.get(node);
    }
}
