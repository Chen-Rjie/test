package 二刷.DFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * DATE: 2021/6/7
 * Author: (Chen)
 */
public class leetcode301 {
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        StringBuilder tmp = new StringBuilder();
        int left = 0,right=0;
        for(int i=0;i<s.length();i++){
            char now = s.charAt(i);
            if(now=='('){
                left++;
            }
            else if(now==')') {
                if(left>0){
                    left--;
                }
                else {
                    right++;
                }
            }
        }
        dfs(s,tmp,0,left,right,0,0);
        if(set.isEmpty()){
            res.add("");
        }
        res.addAll(set);
        return res;
    }
    public void dfs(String s,StringBuilder tmp,int index,int leftRemain,int rightRemain,int errorLeft,int errorRight){
        if(errorRight>0||leftRemain<0||rightRemain<0){
            return;
        }
        if(index==s.length()){
            if(leftRemain==0&&rightRemain==0){
                set.add(tmp.toString());
            }
            return;
        }
        char now = s.charAt(index);
        if(now!='('&&now!=')'){
            tmp.append(now);
            dfs(s,tmp,index+1,leftRemain,rightRemain,errorLeft,errorRight);
            tmp.deleteCharAt(tmp.length()-1);
        }else {
            tmp.append(now);
            int el = errorLeft,er=errorRight;
            if(now=='('){
                el++;
            }
            else {
                if(errorLeft==0){
                    er++;
                }
                else {
                    el--;
                }
            }
            dfs(s,tmp,index+1,leftRemain,rightRemain,el,er);
            tmp.deleteCharAt(tmp.length()-1);
            if(now=='(')
                leftRemain--;
            else
                rightRemain--;
            dfs(s,tmp,index+1,leftRemain,rightRemain,errorLeft,errorRight);
        }

    }

}
