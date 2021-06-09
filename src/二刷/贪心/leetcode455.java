package 二刷.贪心;

import java.util.Arrays;

/*
假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
贪心往往伴随着排序
g = [1,2,3], s = [1,1] res = 1
 */
public class leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        for(int j=0;i<g.length&&j<s.length;j++){
            if(g[i]<=s[j]){
                i++;
            }
        }
        String str = "32";
        Integer.parseInt(str);
        return i;
    }
}
