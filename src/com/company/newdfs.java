package com.company;
import java.util.ArrayList;
public class newdfs {


    public static  class Solution {
        private ArrayList<String> ls = new ArrayList<>();
        private StringBuilder path = new StringBuilder();
        private boolean[] visited;
        private String res = String.valueOf(Integer.MAX_VALUE);
        public String PrintMinNumber(int [] numbers) {
            visited = new boolean[numbers.length];
            dfs(numbers,0);
            return res;
        }
        public void dfs(int [] numbers,int len)
        {
            if(len==numbers.length)
            {
                String ref = concat(ls);
                int now = Integer.parseInt(ref);
                int tmp = Integer.parseInt(res);
                if(tmp>now)
                    res = ref;
                return;
            }
            for(int i=0;i<numbers.length;i++)
            {
                if(visited[i]==false)
                {
                    ls.add(String.valueOf(numbers[i]));
                    visited[i] = true;
                    dfs(numbers,len+1);
                    ls.remove(ls.size()-1);
                    visited[i] = false;
                }

            }
        }
        public String concat(ArrayList<String> ls)
        {
            StringBuilder str = new StringBuilder();
            for(String s :ls)
            {
                str.append(s);
            }
            return str.toString();
        }
    }
    public static void main(String[] args)
    {
        int[] ts = new int[]{3,32,321};
        Solution s = new Solution();
        s.PrintMinNumber(ts);
        System.out.println(s.res);
    }
}
