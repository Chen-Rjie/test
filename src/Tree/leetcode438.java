package Tree;
/*
输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

 */
import java.util.*;
public class leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        int lena = s.length(),lenb = p.length();
        List<Integer> res = new ArrayList<>();
        if(lena<lenb)
            return res;
        int[] need = new int[26];
        int[] count = new int[26];
        for(int i=0;i<p.length();i++){
            int now = p.charAt(i)-'a';
            need[now] += 1;
        }
        //滑动窗口 窗口里的每个元素出现的个数都不超过目标字符串中对应元素出现的个数 探讨每一个以当前滑动窗口右边结束的可能
        int left=0,right=0;
        while(right<lena){
            int curR = s.charAt(right)-'a';
            count[curR]++;
            right++;
            while (count[curR]>need[curR]){
                count[s.charAt(left)-'a']--;
                left++;
            }
            if(right-left==lenb){
                res.add(left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "cbaebabacd";
        String b = "abc";
        new leetcode438().findAnagrams(a,b);
    }
}
