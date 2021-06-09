package other;
//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//
//        对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
//
//        你可以返回任何满足上述条件的数组作为答案。
public class leetcode922 {
//    public int[] sortArrayByParityII(int[] A) {
//        int len = A.length;
//        for(int i=0;i<len;i++){
//            int end = len-1;
//            while (!atpos(A,i)&&end>i){
//                swap(A,i,end--);
//            }
//        }
//        return A;
//    }
//    public boolean atpos(int[] A,int i){
//        if(i%2==0&&A[i]%2==0)
//            return true;
//        if(i%2!=0&&A[i]%2!=0)
//            return true;
//        return false;
//    }
//    public void swap(int[] A,int i,int j){
//        int tmp = A[i];
//        A[i] = A[j];
//        A[j] = tmp;
//    }

    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int[] res = new int[A.length];
        int startoushu = 0,startjishu=1;
        for(int i=0;i<len;i++){
            if(A[i]%2==0){
                res[startoushu] = A[i];
                startoushu += 2;
            }
            else {
                res[startjishu] = A[i];
                startjishu += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ts = {4,2,5,7};
        int[] res = new leetcode922().sortArrayByParityII(ts);
    }
}
