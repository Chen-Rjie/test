package 贪心;
/*
输入: g = [1,2,3], s = [1,1]
输出: 1
解释:
你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
所以你应该输出1。
 */
import java.util.*;
public class leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res=0;
        for(int i=0;i<s.length;i++){
            if(s[i]>=g[res]){
                res++;
                i++;
                if(res==g.length){
                    break;
                }
            }
        }
        return res;
    }

}
