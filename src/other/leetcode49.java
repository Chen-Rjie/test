package other;
////给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//        输出:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
import java.util.*;
public class leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] visted = new int[strs.length];
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i< strs.length;){

            if(visted[i]==1){
                i++;
                continue;
            }
            List<String> line = new ArrayList<>();
            line.add(strs[i]);
            visted[i]=1;
            for(int j=i+1;j< strs.length;j++){
                if(visted[j]==1)
                    continue;
                if(equal(strs[i],strs[j])){
                    line.add(strs[j]);
                    visted[j]=1;
                }

            }
            res.add(line);

        }
        return res;
    }
    public boolean equal(String a,String b){
        int len1=a.length(),len2=b.length();
        if(len1!=len2)
            return false;
        Map<Character,Integer> map1 = new HashMap<>(),map2 = new HashMap<>();
        for(int i=0;i<len1;i++){
            char now = a.charAt(i);
            map1.put(now,map1.getOrDefault(a.charAt(i),0)+1);
        }
        for(int i=0;i<len2;i++){
            char now = b.charAt(i);
            int count = map2.getOrDefault(now,0)+1;
            if(count>map1.getOrDefault(now,0))
                return false;
            map2.put(now,count);
        }

//        Set set = new HashSet();
//        for(int i=0;i<len1;i++){
//            set.add(a.charAt(i));
//        }
//        for(int j=0;j<len2;j++){
//            if(set.add(b.charAt(j))){
//                return false;
//            }
//        }
        return true;
    }

    public static void main(String[] args) {
        String[] ts = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new leetcode49().groupAnagrams(ts);
    }
}
