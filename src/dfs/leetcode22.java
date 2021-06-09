package dfs;
import 链表.ListNode;

import java.util.*;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
//类似于301_hard这道题
//当errorleft==0且error_right==0时，为一个合法解
public class leetcode22 {
    List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder tmp = new StringBuilder();
        dfs(0,n,tmp,0,0,0,0);
        return res;
    }
    public void dfs(int index,int n,StringBuilder tmp,int error_left,int error_right,int choseleft,int choseright)
    {
        //剪枝
        if(error_right>0||choseleft>n||choseright>n)//就是括号匹配的值小于0了
            return;
        if(index==2*n)
        {
            if(error_left==0)
                res.add(new String(tmp));
            return;
        }
        tmp.append('(');
        int el = error_left+1;
        int chleft = choseleft+1;
        dfs(index+1,n,tmp,el,error_right,chleft,choseright);
        tmp.deleteCharAt(tmp.length()-1);
        tmp.append(')');
        int er = error_right;
        int chright = choseright+1;
        if(error_left==0)
        {
            ++er;
        }
        else
        {
            --error_left;
        }
        dfs(index+1,n,tmp,error_left,er,choseleft,chright);
        tmp.deleteCharAt(tmp.length()-1);
    }

    public static void main(String[] args) {
        int ts = 3;
        List<String> res = new leetcode22().generateParenthesis(ts);
    }
}
