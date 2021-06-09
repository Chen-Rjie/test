package 二刷.数组;
/*
数组中出现次数超过一半的数字
 */
public class JZ39 {
//    public int majorityElement(int[] nums) {
//        int target = 0,vote=0;
//        for(int i=0;i<nums.length;i++){
//            if(vote==0){
//                target = nums[i];
//                vote++;
//            }
//            else {
//                vote += target==nums[i]?1:-1;
//            }
//        }
//        return target;
//    }
public static void main(String[] args) {
    int[] a = new int[]{2,2,1,1,1,2,2};
    int res = majorityElement(a);
    System.out.println(res);
}
    public static int majorityElement(int[] nums){
        int start = 0,end = nums.length-1;
        int index = Partition(nums,start,end);
        int mid = nums.length/2;
        while (mid!=index){
            if(index>mid){
                index = Partition(nums,start,index-1);
            }
            else {
                index = Partition(nums,index+1,end);
            }
        }
        return nums[index];
    }
    public static int Partition(int[] array,int start,int end){
        int base = array[start];
        int i = start,j = end;
        while (i<j){
            while (i<j&&array[j]>=base){
                j--;
            }
            if(i<j){
                array[i] = array[j];
                i++;
            }
            while (i<j&&array[i]<base){
                j--;
            }
            if(i<j){
                array[j] = array[i];
                j--;
            }
        }
        array[i] = base;
        return i;
    }
}
