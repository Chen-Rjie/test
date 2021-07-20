package 笔试题;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Chen
 * 2021/6/26 19:39
 */
public class test {
    public static void main(String[] args) {
        /*String a = "zhao";
        String b = "zhu";
        String[] m = {b,a};
        Arrays.sort(m);
        System.out.println(a.compareTo(b));
        for(String s:m){
            System.out.println(s);
        }*/
        Date nowDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        DateFormat df2 = new SimpleDateFormat("HHmmss");  
        System.out.println(df.format(nowDate));
        System.out.println(df2.format(nowDate));
    }
}
