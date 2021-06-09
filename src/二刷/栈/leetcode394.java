package 二刷.栈;

import java.util.Stack;

public class leetcode394 {
    public String decodeString(String s) {
        StringBuffer ans = new StringBuffer();
        Stack<Integer> mulStack = new Stack<>();
        Stack<StringBuffer> ansStack = new Stack<>();
        int mutl = 0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                mutl = mutl*10+c-'0';
            }
            else if(c=='['){
                mulStack.push(mutl);
                ansStack.push(ans);
                ans = new StringBuffer();
                mutl = 0;
            }
            else if(Character.isLetter(c)){
                ans.append(c);
            }
            else {
                StringBuffer tmp = ansStack.pop();
                int num = mulStack.pop();
                for(int i=0;i<num;i++){
                    tmp.append(ans);
                }
                ans = tmp;
            }
        }
        return ans.toString();
    }
}
