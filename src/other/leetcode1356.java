package other;
//给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
//
//        如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
//
//        请你返回排序后的数组。
import java.util.*;
public class leetcode1356 {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        Integer[] arr2 = new Integer[arr.length];
        int[] arr3 = new int[arr.length];
        for(int i=0;i< arr.length;i++){
            arr2[i] = arr[i];
        }
        Arrays.sort(arr2,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                int count1 = countOne(o1),count2 = countOne(o2);
                if(count1-count2==0){
                    return o1-o2>0?1:-1;
                }
                return o1-o2;
            }
        });
        for(int i=0;i< arr.length;i++){
            arr3[i] = arr2[i];
        }
        return arr3;

//        Arrays.sort(arr);
//        int len = arr.length;
//        int[] ref = new int[len];
//        for(int i=0;i<len;i++){
//            ref[i] = countOne(arr[i]);
//        }
//        sort(arr,ref,0,len-1);
//        return arr;
    }
    public int countOne(int n){
        int count = 0;
        while(n>0){
            ++count;
            n = (n-1)&n;
        }
        return count;
    }
    public boolean compare(int[] arr,int[] ref,int i,int j){
        if(ref[i]==ref[j])
            return arr[i]-arr[j]>0;
        return ref[i]-ref[j]>0;
    }
    public void  quicksort(int[] arr,int[]ref, int start,int end){
        if(start>end)
            return ;
        int i = start,j = end,baseref = start;
        while (i<j){
            while (compare(arr,ref,j,baseref)&&i<j){
                j--;
            }
            if(i<j){
                arr[i] = arr[j];
                ref[i] = ref[j];
            }
        }
    }
    public void sort(int[] arr,int[]ref, int start,int end){
        if(start>end)
            return ;
        int baseref = ref[start];
        int base = arr[start];
        int i = start,j = end;
        while (i<j){
            while (ref[j]>baseref&&j>i){
                j--;
            }
            if(i<j){
                if(ref[j]==ref[i]){
                    if(arr[j]<=arr[i])
                    {
//                        arr[i] = arr[j];
//                        ref[i] = ref[j];

                        int tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                        tmp = ref[i];
                        ref[i] = ref[j];
                        ref[j] = tmp;
                    }
                    i++;
                }
                else if(ref[j]<ref[i]){
//                    arr[i] = arr[j];
//                    ref[i] = ref[j];
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    tmp = ref[i];
                    ref[i] = ref[j];
                    ref[j] = tmp;
                    i++;
                }
                else {
                    i++;
                }

            }
            while (ref[i]<baseref&&i<j){
                i++;
            }

            if(i<j)
            {
                if(ref[j]==ref[i]){
                    if(arr[i]>=arr[j])
                    {
//                        arr[j] = arr[i];
//                        ref[j] = ref[i];
                        int tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                        tmp = ref[i];
                        ref[i] = ref[j];
                        ref[j] = tmp;
                    }
                    j--;
                }
                else if(ref[i]>ref[j]){
//                    arr[j] = arr[i];
//                    ref[j] = ref[i];
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    tmp = ref[i];
                    ref[i] = ref[j];
                    ref[j] = tmp;
                    j--;
                }
                else {
                    j--;
                }
            }
        }
//        arr[i] = base;
//        ref[i] = baseref;
        sort(arr,ref,start,i-1);
        sort(arr,ref,i+1,end);
        return ;
    }

    public static void main(String[] args) {
        int [] ts = {0,1,2,3,4,5,6,7,8};
        int[] res = new leetcode1356().sortByBits(ts);
    }
}
