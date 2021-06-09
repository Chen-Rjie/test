package 二刷.DFS;

import java.util.HashMap;

/**
 * DATE: 2021/6/7
 * Author: (Chen)
 */
public class leetcode114 {
    public void flatten() {
        ThreadLocal nes = new ThreadLocal();
        ThreadLocal nes1 = new ThreadLocal();
//        nes.set("chen");
//        nes1.set("ren");
//        System.out.println(nes.get());
//        System.out.println(nes1.get());
        new Thread(()->{
            nes.set("chen");
            nes1.set("ren");
            System.out.println(nes.get());
            System.out.println(nes1.get());
        }).start();
        new Thread(()->{
            nes.set("zhang");
            nes1.set("haitao");
            System.out.println(nes.get());
            System.out.println(nes1.get());
        }).start();
    }

    public static void main(String[] args) {
        new leetcode114().flatten();
    }
}
