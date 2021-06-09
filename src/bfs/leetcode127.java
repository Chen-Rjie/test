package bfs;
//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//        每次转换只能改变一个字母。
//        转换过程中的中间单词必须是字典中的单词。
//        说明:
//
//        如果不存在这样的转换序列，返回 0。
//        所有单词具有相同的长度。
//        所有单词只由小写字母组成。
//        字典中不存在重复的单词。
//        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
import java.util.*;
public class leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 0;
        Map<String,Integer> map = new HashMap<>();
        if(!wordList.contains(endWord))
            return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()){
            int sz = queue.size();
            ++level;
            while (sz-->0){
                String now = queue.poll();
                if(now.equals(endWord))
                    return level;
                for(String str : wordList)
                {
                    if(cantrans(now,str)&&map.getOrDefault(str,0)==0)
                    {
                        queue.offer(str);
                        map.put(str,1);//str此时已经被转化了
                    }
                }
            }
        }
        return 0;
    }
    public boolean cantrans(String from,String end)
    {
        int count = 0,len = from.length();
        for(int i=0;i<len;i++)
        {
            if(from.charAt(i)!=end.charAt(i)){
                count++;
            }
            if(count==2)
                return false;
        }
        return count==1;
    }

    public static void main(String[] args) {
        String begin = "hit",end = "cog";
        List<String> ts = Arrays.asList("hot","dot","dog","lot","log","cog");
        int res = new leetcode127().ladderLength(begin,end,ts);
    }


}
