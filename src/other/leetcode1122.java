package other;
//给你两个数组，arr1 和 arr2，
//
//        arr2 中的元素各不相同
//        arr2 中的每个元素都出现在 arr1 中
//        对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//        输出：[2,2,2,1,4,3,3,9,6,7,19]

//利用流来转换
//int[] nums = {1,2,3};
////先将int数组转换为数值流
//        IntStream stream = Arrays.stream(nums);
////流中的元素全部装箱，转换为流 ---->int转为Integer
//        Stream<Integer> integerStream = stream.boxed();
////将流转换为数组
//        Integer[] integers = integerStream.toArray(Integer[]::new);
//        System.out.println(Arrays.toString(integers));
import java.util.*;
public class leetcode1122 {
    Map<Integer,Integer> num2pos;
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len2 = arr2.length;
        num2pos = new HashMap<>();
        for(int i=0;i<len2;i++){
            num2pos.put(arr2[i],i);
        }
        for(int num:arr1){
            if(!num2pos.containsKey(num)){
                num2pos.put(num,num+len2);
            }
        }
        int start = 0,end = arr1.length-1;
        quicksort(arr1,start,end);
//        Arrays.sort(arr1,new Comparator<Integer>(){
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        });
        return arr1;
    }
    public void quicksort(int[] arr ,int start,int end){
        if(start>end)
            return;
        int base = arr[start];
        int basenum = num2pos.get(base);
        int i = start , j = end;
        while (i<j){
            while (i<j&&num2pos.get(arr[j])>=basenum){
                j--;
            }
            if(i<j){
                arr[i] = arr[j];
                i++;
            }
            while (i<j&&num2pos.get(arr[i])<basenum){
                i++;
            }
            if(i<j){
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = base;
        quicksort(arr,start,i-1);
        quicksort(arr,i+1,end);

    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 ={2,1,4,3,9,6};
        int[] res = new leetcode1122().relativeSortArray(arr1,arr2);
    }
}
