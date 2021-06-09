package dfs;
//视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
//
//        给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
//
//        最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
//
//        旋转 ring 拼出 key 字符 key[i] 的阶段中：
//
//        您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
//        如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。

import java.util.*;
public class leetcode514_hard {
    int mincount = 10000;
    int ringlen;
    int[][] memo;
    Map<Character,List<Integer>> map = new HashMap<>();
    public int findRotateSteps(String ring, String key) {
        ringlen = ring.length();
        for(int i=0;i<ringlen;i++){
            char ch = ring.charAt(i);
            if(map.containsKey(ch)){
                map.get(ch).add(i);
            }
            else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(ch,tmp);
            }
        }
        memo = new int[ring.length()][key.length()];
        return dfs(ring,key,0,0);

    }

    //自己写的dfs 有问题
//    public void dfs(String ring,String key,int index,int keyindex,int count){
//        if(ring.charAt(index)==key.charAt(keyindex)){
//            count++;
//            keyindex++;
//        }
//        if(keyindex==key.length()){
//            mincount = Math.min(mincount,count);//按下拼凑
//            return;
//        }
//
//        count++;//往右走一步
//        dfs(ring,key,(index+1)%ringlen,keyindex,count);
////        count--;
////        count++;//往左
//        dfs(ring,key,index>0?index-1:ringlen,keyindex,count);
////        count--;
//    }


    public int dfs(String ring,String key,int index,int keyindex){
        if(key.length()==keyindex){
            return 0;
        }
        if(memo[index][keyindex]!=0)
            return memo[index][keyindex];
        char now = key.charAt(keyindex);
        List<Integer> tmp = map.get(now);
        int res = 10000;
        for(int pos : tmp){
            int distance = dfs(ring,key,pos,keyindex+1);
            int left = distance+Math.abs(pos-index)+1;
            int right = distance+Math.abs(ringlen-Math.abs(pos-index)+1);
            res = Math.min(res,Math.min(left,right));
        }
        memo[index][keyindex] = res;
        return res;


    }

    public static void main(String[] args) {
        String ts = "godding",key="godding";
        int res = new leetcode514_hard().findRotateSteps(ts,key);
    }
}
