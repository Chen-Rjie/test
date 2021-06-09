package dfs;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
import java.util.*;
public class leetcode17 {
//    List<String> res = new ArrayList<>();
//    public List<String> letterCombinations(String digits) {
//        Map<Character, String> map = new HashMap<Character, String>() {
//            {
//                put('2', "abc");
//                put('3', "def");
//                put('4', "ghi");
//                put('5', "jkl");
//                put('6', "mno");
//                put('7', "pqrs");
//                put('8', "tuv");
//                put('9', "wxyz");
//            }
//        };
//        dfs(new StringBuilder(),map,digits,0);
//        return res;
//    }
//    public void dfs(StringBuilder tmp,Map<Character, String> map,String digits,int lv)
//    {
//        if(lv==digits.length())
//        {
//            String line = new String(tmp);
//            if(!line.equals(""))
//                res.add(line);
//            return;
//        }
//        char now = digits.charAt(lv);
//        String str = map.get(now);
//        for(int i=0;i<str.length();i++)
//        {
//            tmp.append(str.charAt(i));
////            if(map.containsKey(now))
////            {
////                tmp.append(now);
////            }
//            dfs(tmp,map,digits,lv+1);
//            tmp.deleteCharAt(tmp.length()-1);
//        }
//    }
public List<String> letterCombinations(String digits) {
    List<String> combinations = new ArrayList<String>();
    if (digits.length() == 0) {
        return combinations;
    }
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
    return combinations;
}

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        String ts = "";
        List<String> res = new leetcode17().letterCombinations(ts);
    }
}
