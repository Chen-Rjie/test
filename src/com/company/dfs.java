package com.company;
import java.util.ArrayList;
public class dfs {
    public static void main(String[] args)
    {
        int[] ts = new int[]{10,5,12,4,7};
        int target = 22;
        TreeNode node = new dfs().create(ts,0);

        ArrayList<ArrayList<Integer>> res = new Solution4().FindPath(node,target);
    }

    public TreeNode create(int[] array,int index)
    {
        TreeNode tn = null;
        if(array==null)
            return null;
        if (index<array.length) {
            int value = array[index];
            tn = new TreeNode(value);
            tn.left = create(array, 2*index+1);
            tn.right = create(array, 2*index+2);
            return tn;
        }
        return tn;
    }
}


class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;
 public TreeNode(int val) {
 this.val = val;

 }

 }
class Solution4 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        int sum = 0;
        dfs(root,res,path,sum,target);
        return res;
    }
    public void dfs(TreeNode node,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> path,int sum,int target)
    {
        if(node==null)
        {
            if(sum==target)
            {
                //要深拷贝
                ArrayList<Integer> now = (ArrayList<Integer>) path.clone();
                //ArrayList重写了equals方法 首先比较地址然后比较里面的每一个元素
                if(!res.contains(now))
                    res.add(now);
            }
        }
        else{
            int val = node.val;
            path.add(val);
            sum += val;
            dfs(node.left,res,path,sum,target);
            dfs(node.right,res,path,sum,target);
            int sz = path.size();
            path.remove(sz-1);
            sum -= val;
        }

    }
}