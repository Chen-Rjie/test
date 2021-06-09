package dfs;

/**
 * Created by Chen
 * 2021/6/9 22:20
 */
/*
递归
 */
public class n阶乘 {
    public static long dfs(long n){
        if(n==1)
            return 1L;
        return n*dfs(n-1);
    }

    public static void main(String[] args) {
        long ts = 50;
        System.out.println(dfs(ts));
    }
}
