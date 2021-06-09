package dfs;

import java.util.*;

public class leetcode301_dfs {
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();

        int canleft =0, canright=0;
        //查找有几个未匹配的括号，删除的时候只能删除这几个括号
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                canleft++;
            if(s.charAt(i)==')')
            {
                if(canleft==0)
                    canright++;
                else
                    canleft--;
            }
        }
        StringBuilder tmp = new StringBuilder();
        dfs(s,tmp,0,canleft,canright,0,0);
        if(set.isEmpty())
        {
            res.add("");
        }
        else {
            res = new LinkedList<>(set);
        }
        return res;
    }
    public void dfs(String s,StringBuilder tmp ,int index ,int canleft, int canright ,int errorLeft, int errorRight)
    {
        if(errorRight>0||canleft<0||canright<0)
        {
            return;
        }
        if(index==s.length()){
            if(canleft==0&&canright==0)
            {
                set.add(new String(tmp));
            }
            return;
        }
        //不为括号
        char now = s.charAt(index);
        if(now!='('&&now!=')')
        {
            tmp.append(now);
            dfs(s,tmp,index+1,canleft,canright,errorLeft,errorRight);
            tmp.deleteCharAt(tmp.length()-1);
        }
        else {
            //不删
            tmp.append(now);
            int el = errorLeft,er = errorRight;
            if(now=='(')
                el++;
            else
            {
                if(el!=0)
                    el--;
                else
                    er++;
            }
            dfs(s,tmp,index+1,canleft,canright,el,er);
            tmp.deleteCharAt(tmp.length()-1);
            //删除
            if(now=='(')
                canleft--;
            else
                canright--;
            dfs(s,tmp,index+1,canleft,canright,errorLeft,errorRight);

        }
    }
    public static void main(String[] args)
    {
        String test = "()())()";
        List<String> res = new leetcode301_dfs().removeInvalidParentheses(test);
    }
}
