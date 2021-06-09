package 二刷.堆;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
239. 滑动窗口最大值
 */
public class leetcode239 {
    public static void main(String[] args) {
        int[] ts = new int[]{7,2,4};
        int[] res = maxSlidingWindow1(ts,2);
        System.out.println("ss");
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int lenN = nums.length;
        int[] res = new int[lenN-k+1];
        if(lenN<k)
            return res;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]!=b[0]?b[0]-a[0]:b[1]-a[1]);
        for(int i=0;i<k;i++){
            queue.offer(new int[]{nums[i],i});
        }
        int first = queue.peek()[0];//这里要是peek 不能是poll 因为最大值不一定是第一个元素
        res[0] = first;
        for(int i=k;i<lenN;i++){
            queue.offer(new int[]{nums[i],i});
            while (queue.peek()[1]<=i-k){
                queue.poll();
            }
            res[i-k+1] = queue.peek()[0];
        }
        return res;
    }
    //单调栈的另一个应用  或者说单调队列的另一个应用 队首始终是最值 比堆的复杂度要来的低
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<k;i++){
            while (!deque.isEmpty()&&nums[i]>nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int num = nums[deque.peekFirst()];
        res[0] = num;
        for(int i=k;i<n;i++){
            while (!deque.isEmpty()&&nums[i]>nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            res[i-k+1] = nums[deque.peekFirst()];

        }
        return res;
    }
}
