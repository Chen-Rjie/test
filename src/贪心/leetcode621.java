package 贪心;

import java.util.Arrays;

/*
给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
你需要计算完成所有任务所需要的最短时间。*

 */
public class leetcode621 {
    public int leastInterval(char[] tasks, int n) {
        int count = 0;
        int[] map = new int[26];
        for(char ch:tasks){
            map[ch-'A'] += 1;
        }
        Arrays.sort(map);
        while (map[25]>0){
            for(int i=0;i<n+1;i++){
                if(map[25]==0)
                    break;
                if(25-i>=0&&map[25-i]>0)
                {
                    map[25-i]--;
                }
                count++;
            }
            Arrays.sort(map);
        }
        return count;
    }

    public static void main(String[] args) {
        char[] ts = {'A','A','A','B','B','B'};
        int n = 2;
        int res = new leetcode621().leastInterval(ts,n);
    }
}
