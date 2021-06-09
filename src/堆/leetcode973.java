package 堆;
import java.util.*;
public class leetcode973 {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length,start = K;
        if(len<K){
            return null;
        }
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return powsum(o2)-powsum(o1);
            }
        });
        for(int i=0;i<K;i++){
            queue.offer(points[i]);
        }
        while (start<len){
            int num = powsum(queue.peek());
            int now = powsum(points[start]);
            if(now<num){
                queue.poll();
                queue.offer(points[start]);
            }
            start++;
        }
        int[][] res = new int[K][];
        for(int i =0;i<K;i++){
            res[i] = queue.poll();
        }
        return res;
//        return queue.toArray();

    }
    public int powsum(int[] a){
        return (int)(Math.pow(a[0],2)+Math.pow(a[1],2));
    }

    public static void main(String[] args) {
        int[][] ts = {{1,3},{-2,2}};
        int n = 1;
        int[][] res = new leetcode973().kClosest(ts,n);
    }
}
