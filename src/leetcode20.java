import java.util.*;
public class leetcode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char now = s.charAt(i);
            if(now=='('||now=='{'||now=='[')
            {
                stack.push(now);
            }
            else
            {
                if(stack.isEmpty())
                    return false;
                char in = stack.pop();
                switch (now)
                {
                    case '}':{
                        if(in!='{')
                            return false;
                        break;
                    }
                    case ']':
                    {
                        if(in!='[')
                            return false;
                        break;
                    }
                    case ')':
                    {
                        if(in!='(')
                            return false;
                        break;
                    }
                    default:
                        return false;
                }

            }

    }
        if(!stack.isEmpty())
            return false;
        return true;
    }
    public static void main(String args[])
    {
        String ts = "[";
        boolean res = new leetcode20().isValid(ts);

    }
}
