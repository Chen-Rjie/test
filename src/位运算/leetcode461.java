package 位运算;

public class leetcode461 {
    public int hammingDistance(int x, int y) {
        int res = x^y;
        int count = 0;
        while (res!=0)
        {
//            int leave = res%2;
//            if(leave==1)
//                count++;
            if((res&1)>0)
                count++;
            res = res>>1;
        }
        return count;
    }
}
