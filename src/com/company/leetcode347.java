package com.company;
import java.util.*;
//hash + 大根堆
public class leetcode347 {
    /*class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i< nums.length;i++)
            {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1 );
            }
            /////优先队列默认的小根堆
            Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1]-o2[1];
                }
            });
            for(Map.Entry<Integer,Integer> entry : map.entrySet())
            {
                int num = entry.getKey(),count = entry.getValue();
                if(queue.size()==k)
                {
                    if(count>queue.peek()[1])
                    {
                        queue.poll();
                        queue.offer(new int[]{num, count});
                    }
                }
                else {
                    queue.offer(new int[]{num,count});
                }
            }
            int[] res = new int[k];
            for(int i=0;i<k;i++)
            {
                res[i] = queue.poll()[0];
            }
            return  res;
        }
    }*/
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            List<int[]> values = new ArrayList<int[]>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getKey(), count = entry.getValue();
                values.add(new int[]{num, count});
            }
            int[] ret = new int[k];
            qsort(values,0, values.size(),ret,0,k);
            return ret;
        }
        public void qsort(List<int[]> values,int start,int end,int[] ret,int retindex,int k)
        {
            int base = start + (int)((end-start+1)*Math.random());
            Collections.swap(values,base,start);
            int pivot = values.get(base)[1];
            int i = start,j=end;
            while(i<j)
            {
                while(i<j&&values.get(j)[1]>=pivot)
                {
                    j--;
                }
                if(i<j)
                {
                    Collections.swap(values,i,j);
                    i++;
                }
                while(i<j&&values.get(i)[1]<=pivot){
                    i++;
                }
                if(i<j)
                {
                    Collections.swap(values,i,j);
                    j--;
                }
            }
            if(k<i-start+1)
            {
                qsort(values,start,i-1,ret,retindex,k);
            }
            else
            {
                for(int m=start;m<=i;m++)
                {
                    ret[retindex++] = values.get(m)[0];
                }
                if(k>i-start+1)
                {
                    qsort(values,i+1,end,ret,retindex,k-(i-start+1));
                }
            }
        }
    }
}
