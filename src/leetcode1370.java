/*
给你一个字符串 s ，请你根据下面的算法重新构造字符串：

从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
重复步骤 2 ，直到你没法从 s 中选择字符。
从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
重复步骤 5 ，直到你没法从 s 中选择字符。
重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
输入：s = "aaaabbbbcccc"
输出："abccbaabccba"
解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
*/
import java.util.*;
import java.util.stream.Collectors;

public class leetcode1370 {
    public String sortString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
//        List keys = map.keySet().stream().collect(Collectors.toList());
        List<Character> ls = new ArrayList(map.keySet());
        Collections.sort(ls);
        StringBuilder stringBuilder = new StringBuilder();
        int flag=1;
        while (true){
//            int len = ls.size();
            if(ls.size()==0){
                break;
            }
            StringBuilder tmp = new StringBuilder();
            for(int i=0;i<ls.size();){
                char now = ls.get(i);
                if(map.containsKey(now)){
                    if(flag==1){
                        tmp.append(now);
                    }
                    else {
                        tmp.insert(0,now);
                    }
                    int count = map.get(now)-1;
                    map.put(now,count);
                    if(count==0)
                    {
                        map.remove(now);
                        ls.remove(i);
                        continue;
                    }
                }
                ++i;
            }
            stringBuilder.append(tmp);
            flag *= -1;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String ts = "aabb";
        String res = new leetcode1370().sortString(ts);
    }
}
