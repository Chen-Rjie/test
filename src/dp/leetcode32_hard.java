package dp;
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
import java.util.*;
public class leetcode32_hard {
    //首先用栈的思想来做
//    public int longestValidParentheses(String s) {
//        int len = s.length();
//        int maxlen = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        for(int i=0;i<len;i++)
//        {
//            char now = s.charAt(i);
//            if(now=='(')
//            {
//                stack.push(i);
//            }
//            else {
//                int top = stack.peek();
//                int sz = stack.size();
//                if(sz==1)//到栈底了
//                {
//                    stack.pop();
//                    stack.push(i);
//                }
//                else {
//                    stack.pop();
//                    maxlen = Math.max(maxlen,i-stack.peek());
//                }
//            }
//        }
//        return maxlen;
//    }


    //dp的方法
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len==1)
            return 0;
        int[] dp = new int[len];
        int res = 0;
        for(int i=1;i<len;i++)
        {
            char tmp = s.charAt(i);
            if(tmp =='(')
                dp[i] = 0;
            else {
                if (i == 1) {
                    dp[i] = s.charAt(0) == '(' ? 2 : 0;
                }
                else {
                    if (s.charAt(i - 1) == '(')
                        dp[i] = dp[i - 2] + 2;
                    else {
                        if (i - dp[i - 1] - 1 < 0)
                            dp[i] = 0;//没有匹配当前反括号的
                        else if (i - dp[i - 1] - 1 == 0) {
                            dp[i] = s.charAt(0) == '(' ? dp[i - 1] + 2 : 0;
                        } else {
                            if (s.charAt(i - dp[i - 1] - 1) == '(')//要是为')'前面不可能有和最后一个）匹配的
                            {
                                dp[i] = dp[i - dp[i - 1] - 2] + dp[i - 1] + 2;
                            } else
                                dp[i] = 0;


                        }
                    }
                }
            }
            res = Math.max(res,dp[i]);
        }
        return  res;
    }


    public static void main(String[] args) {
        String ts = "()(()";
        int res = new leetcode32_hard().longestValidParentheses(ts);
    }
}
