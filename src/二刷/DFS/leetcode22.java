package 二刷.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen
 * 2021/6/14 10:47
 */
/*
括号匹配
 */
public class leetcode22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder str = new StringBuilder();
        dfs(0,n,str,0,0,0,0);
        return res;
    }
    public void dfs(int level,int n,StringBuilder str,int errorLeft,int errorRight,int chooseLeft,int chooseRight){
        if(errorRight>0||chooseLeft>n||chooseRight>n)
            return;
        if(level==n*2){
            if(errorLeft==0&&errorRight==0)
            {
                res.add(str.toString());
            }
            return;
        }
        //选左括号
        str.append('(');
        dfs(level+1,n,str,errorLeft+1,errorRight,chooseLeft+1,chooseRight);
        str.deleteCharAt(str.length()-1);
        str.append(')');
        if(errorLeft!=0){
            dfs(level+1,n,str,errorLeft-1,errorRight,chooseLeft,chooseRight+1);
        }
        else{
            dfs(level+1,n,str,errorLeft,errorRight+1,chooseLeft,chooseRight+1);
        }
        str.deleteCharAt(str.length()-1);

    }
}
