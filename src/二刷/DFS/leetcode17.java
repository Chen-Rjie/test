package 二刷.DFS;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * DATE: 2021/6/7
 * Author: (Chen)
 */
/*
给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 */
public class leetcode17 {
    ArrayList<String> res = new ArrayList<>();
    Map<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    public List<String> letterCombinations(String digits) {
//        Map<Character,String> map = new HashMap<>();
//        //List中可以存放none
//        map.put('2',"abc");
//        map.put('3',"def");
        StringBuilder tmp = new StringBuilder();
        dfs(digits,0,tmp);
        if(res.isEmpty())
        {
            res.add("");

        }
        return res;

    }
    public void dfs(String digits,int index,StringBuilder tmp){
        if(index==digits.length()){
            res.add(tmp.toString());
            return;
        }
        char now = digits.charAt(index);
        for(char ch:map.get(now).toCharArray()){
            tmp.append(ch);
            dfs(digits,index+1,tmp);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
}
