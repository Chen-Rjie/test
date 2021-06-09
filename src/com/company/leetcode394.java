package com.company;
import java.util.*;
public class leetcode394 {
    int i;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<String> deque = new LinkedList<>();

        //Deque<StringBuilder> deque = new LinkedList<>();
        boolean flag = false;

        for(i=0;i<s.length();)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                String times = getTimes(s);
                deque.addLast(times);
            }
            else if(Character.isLetter(s.charAt(i))||s.charAt(i)=='[')
            {
                deque.addLast(String.valueOf(s.charAt(i)));
                i++;
            }
            else {
                StringBuilder temp = new StringBuilder();
                while(!deque.peekLast().equals('['))
                {
                    temp.insert(0,deque.pollLast());
                }
                deque.pollLast();
                String onetemp = temp.toString();

                temp.replace(0,temp.length(),"");
                int time = Integer.parseInt(deque.pollLast());
                while(time-->0)
                {
                    temp.append(onetemp);
                }
                deque.addLast(temp.toString());
                i++;
            }

        }
        while(!deque.isEmpty())
        {
            res.append(deque.pollFirst());
        }
        return res.toString();
    }
    public String getTimes(String s)
    {
        StringBuilder str = new StringBuilder();
        while(i<s.length()&&Character.isDigit(s.charAt(i)))
        {
            str.append(s.charAt(i));
            i++;
        }
        return str.toString();
    }
    public static void main(String[] args)
    {
        String ts = "3[a]2[bc]";
        String res = new leetcode394().decodeString(ts);

    }
}
