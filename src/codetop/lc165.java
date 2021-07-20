package codetop;

/**
 * Created by Chen
 * 2021/7/8 20:59
 */
public class lc165 {
    public static void main(String[] args) {
        String tmp1 = "0.11";
        String tmp2 = "0.21";
        String[] e = tmp1.split("\\.");
        System.out.println(e.length);
        int res = new lc165().compareVersion(tmp1,tmp2);
        System.out.println(res);
    }
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i=0;i<Math.max(v1.length,v2.length);i++){
            int ch1 = (i>=v1.length)?0:Integer.parseInt(v1[i]);
            int ch2 = (i>=v2.length)?0:Integer.parseInt(v2[i]);
            if(ch1<ch2)
                return -1;
            else if(ch1>ch2)
                return 1;
        }
        return 0;
    }
}
