package 二刷.堆;

import java.util.*;

/*
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

可以用优先级队列建堆做
也可以用二分的思想做
 */
public class leetcode347 {
    public static void main(String[] args) {
        int[] ts = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] res = new leetcode347().topKFrequent(ts,k);
        System.out.println("sss");
    }
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> occurrences = new HashMap<>();
            for (int num : nums) {
//                occurrences.put(num,occurrences.getOrDefault(num,0)+1);
                occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
            }

            List<int[]> values = new ArrayList<int[]>();
            for(Map.Entry<Integer,Integer> entry:occurrences.entrySet()){
                int num = entry.getKey(),count = entry.getValue();
                values.add(new int[]{num,count});
            }
//            for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
//                int num = entry.getKey(), count = entry.getValue();
//                values.add(new int[]{num, count});
//            }
            int[] ret = new int[k];
            qsort(values, 0, values.size() - 1, ret, 0, k);
            return ret;
        }

        public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
            int picked = (int) (Math.random() * (end - start + 1)) + start;
            int base = values.get(picked)[1];
            int i = start,j=end;
            while (i<j){
                while (i<j&&values.get(j)[1]<=base){
                    j--;
                }
                if(i<j){
                    Collections.swap(values, i, j);
                    i++;
                }
                while (i<j&&values.get(i)[1]>base){
                    i++;
                }
                if(i<j){
                    Collections.swap(values, i, j);
                    j--;
                }
            }
            int index = i;
//            Collections.swap(values, picked, start);
//
//            int pivot = values.get(start)[1];
//            int index = start;
//            for (int i = start + 1; i <= end; i++) {
//                if (values.get(i)[1] >= pivot) {
//                    Collections.swap(values, index + 1, i);
//                    index++;
//                }
//            }
//            Collections.swap(values, start, index);

            if (k <= index - start) {
                qsort(values, start, index - 1, ret, retIndex, k);
            } else {
                for (int m = start; m <= index; m++) {
                    ret[retIndex++] = values.get(m)[0];
                }
                if (k > index - start + 1) {
                    qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
                }
            }


}
}
