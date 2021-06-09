package com.company;

class Solution1 {
    public boolean match(char[] str, char[] pattern)
    {
        //使用递归先写出结束条件
        int len1 = str.length,len2 = pattern.length;
        if(len1==0||len2==0)
            return false;
        boolean res = core(str,pattern,0,0);
        return res;
    }
    public boolean core(char[] str, char[] pattern,int index1,int index2)
    {
        if(str[index1]=='\0'&&pattern[index2]=='\0')
            return true;
        if(str[index1]!='\0'&&pattern[index2]=='\0')
            return false;//pattern先到末尾
        if(pattern[index2+1]=='*')
        {
            if(str[index1]==pattern[index2]||(pattern[index2]=='.'&&str[index1]!='\0'))
            {
                return core(str,pattern,index1,index2+2)||core(str,pattern,index1+1,index2)||
                        core(str,pattern,index1+1,index2+2);
            }
            else
            {
                return core(str,pattern,index1,index2+2);
            }
        }
        if(str[index1]==pattern[index2]||(pattern[index2]=='.'&&str[index1]!='\0'))
            return core(str,pattern,index1+1,index2+1);
        else
            return false;
    }
}
public class str{
    public static void main(String[] args)
    {
        char[] strtest = {'a','a','a','\0'};
        char[] pa = {'a','b','*','a','c','*','a','\0'};
        boolean res = new Solution1().match(strtest,pa);
        System.out.println(res);
    }
}
