package com.company;
import java.util.Stack;
public class reverse {

    public static class Solution {
        public String ReverseSentence(String str) {
            if(str==null||str.length()==0)
                return new String();
            char[] strs = str.toCharArray();
            int i=0,j=strs.length-1;
            while(i<j)
            {
                char temp = strs[i];
                strs[i] = strs[j];
                strs[j] = temp;
                ++i;
                --j;
            }
            Stack<Character> stack = new Stack<>();
            StringBuilder res = new StringBuilder();
            for(int k=0;k<strs.length;k++)
            {
                if(strs[k]==' ')
                {
                    while(!stack.isEmpty())
                    {
                        char tmp = stack.pop();
                        res.append(tmp);
                    }
                    res.append(' ');
                }
                else{
                    stack.push(strs[k]);
                }
            }
            while(!stack.isEmpty())
            {
                char tmp = stack.pop();
                res.append(tmp);
            }
            return res.toString();
        }
    }
    public static void main(String[] args)
    {
//        char[] strtest = {'a','a','a','\0'};
//        char[] pa = {'a','b','*','a','c','*','a','\0'};
//        boolean res = new Solution().ReverseSentence()
        String str = "";
        String res = new Solution().ReverseSentence(str);
        System.out.println(res);
    }
}
