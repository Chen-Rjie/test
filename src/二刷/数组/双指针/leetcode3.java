package 二刷.数组.双指针;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chen
 * 2021/6/10 15:40
 */
public class leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left=0,right=0;
        int flag = 0;
        int res = 0;
        while (left<s.length()){
            if(flag==0){
                while (right<s.length()&&!set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    right++;
                }
                flag = 1;
            }
            else {
                set.remove(s.charAt(left-1));
                while (right<s.length()&&!set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    right++;
                }
            }
            res =Math.max(res,right-left);
            left++;

        }
        return res;

    }

}
