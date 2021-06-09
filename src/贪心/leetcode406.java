package 贪心;
import java.util.*;
public class leetcode406 {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });
        for(int[] p:people){
            res.add(p[1],p);
        }
        return res.toArray(new int[people.length][2]);
    }
}
