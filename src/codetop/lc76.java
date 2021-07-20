package codetop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Chen
 * 2021/7/10 19:12
 */
public class lc76 {
    Map<Character,Integer> target = new HashMap<>();
    Map<Character,Integer> total = new HashMap<>();
    public String minWindow(String s, String t) {
        int left = 0,right = -1;
        int resLeft = -1,resRight = -1;
        int minLen = Integer.MAX_VALUE;

        for(Character ch:t.toCharArray()){
            target.put(ch, target.getOrDefault(ch,0)+1);
        }
        while(right<s.length()){
            right++;
            if(right<s.length()&&target.containsKey(s.charAt(right)))
                total.put(s.charAt(right),total.getOrDefault(s.charAt(right),0)+1);
            while (check()&&left<=right){

                if(right-left+1<minLen){
                    resLeft = left;
                    resRight = right+1;
                }
                if (target.containsKey(s.charAt(left))) {
                    total.put(s.charAt(left), total.getOrDefault(s.charAt(left), 0) - 1);
                }
//                total.put(s.charAt(left), total.getOrDefault(s.charAt(left),0)-1);
                left++;
            }
        }
        return resLeft==-1?"": s.substring(resLeft,resRight);
    }
    public boolean check(Map<Character,Integer> target,Map<Character,Integer> total){
        for(Map.Entry<Character,Integer> entry:target.entrySet()){
            char ch = (Character)entry.getKey();
            if((Integer)entry.getValue()>total.getOrDefault(ch,0)){
                return false;
            }
        }
        return true;
    }
    public boolean check(){
        Iterator iter = target.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (total.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        String res = new lc76().minWindow(s,t);
        System.out.println(res);
    }
}
