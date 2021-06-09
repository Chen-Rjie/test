package dfs;
import java.util.*;
public class leetcode301_hard {
    //BFS
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        List<String> res = new LinkedList<>();
        Set<String> set=new HashSet<>();
        queue.offer(s);
        while (!queue.isEmpty())
        {
            int sz = queue.size();
            //res = filter(queue);
//            if(!res.isEmpty())
//            {
//                return new ArrayList<>(new HashSet<>(res));
//            }
            boolean flag = false;
            while (sz-->0)
            {
                String now = queue.poll();

                if(isValid(now))
                {
                    res.add(now);
                    flag = true;
                }
                if(flag)
                    continue;
                int len = now.length();
                for(int i=0;i<len;i++)
                {
                    StringBuilder tmp = new StringBuilder(now);
                    if(now.charAt(i)!='('&&now.charAt(i)!=')')
                        continue;
                    tmp.replace(i,i+1,"");

                    if(set.add(tmp.toString()))
                    {
                        queue.offer(tmp.toString());
                    }
                }
            }
            if(flag)
                return res;

        }
        if(res.isEmpty())
            res.add("");
        return res;
    }
    public boolean isValid(String str)
    {
        int flag = 0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='(')
                flag++;
            else if(str.charAt(i)==')')
                flag--;
            if(flag<0)
                return false;
        }
        if(flag==0)
            return true;
        return false;
    }
    public List<String> filter(Queue<String> q)
    {
        List<String> res = new LinkedList<>();
        for(String s: q)
        {
            if(isValid(s))
            {
                res.add(s);
            }

        }
        return res;
    }
    public static void main(String[] args)
    {
        String test = "()((((((()l(";
        List<String> res = new leetcode301_hard().removeInvalidParentheses(test);
    }
}
