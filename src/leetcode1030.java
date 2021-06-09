import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int num=R*C,r=1,index=0;
        int[][] res = new int[num][2];
        ArrayList<LinkedList<int[]>> bucket = new ArrayList<>();
        int maxdis = Math.max(r0,R-1-r0)+Math.max(c0,C-1-c0);
//        res[0] = new int[]{r0,c0};
        for(int i=0;i<=maxdis;i++){
            bucket.add(new LinkedList<>());
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                int d = dist(i,j,r0,c0);
                bucket.get(d).add(new int[]{i,j});
            }
        }
        for(int i=0;i<bucket.size();i++){
            LinkedList<int[]> tmp = bucket.get(i);
            for(int j=0;j<tmp.size();j++){
                res[index++] = tmp.get(j);
            }
        }
        return res;







        //中心扩散
//        for(int i=1;i<=maxdis;i++){
//            maxd
//        }
//        while (true){
//            int[][] dic = {{-r,0},{r,0},{0,r},{0,-r}};
//            for(int i=0;i<8;i++)
//            {
//                if(index==num){
//                    return res;
//                }
//                int[] tmp = {r0+dic[i][0],c0+dic[i][1]};
//                if(check(tmp,R,C)){
//                    res[index++] = tmp;
//                }
//            }
//            r++;
//        }
    }
    public boolean check(int[] pos,int R,int C){
        if(pos[0]<0||pos[0]>=R||pos[1]<0||pos[1]>=C){
            return false;
        }
        return true;
    }
    private int dist(int r1,int c1,int r2,int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }


    public static void main(String[] args) {
        int R = 2,C=2,r0=0,c0=1;
        int[][] res = new leetcode1030().allCellsDistOrder(R,C,r0,c0);
    }



}
