package 二刷.贪心;

/**
 * DATE: 2021/5/28
 * Author: (Chen)
 */
/*
种花问题
相邻的不能种在一起
 */
public class leetcode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n){
        int count = 0;
        int m = flowerbed.length;
//        int prev = -1;
//        for (int i = 0; i < m; i++) {
//            if (flowerbed[i] == 1) {
//                if (prev < 0) {
//                    count += i / 2;
//                } else {
//                    count += (i - prev - 2) / 2;
//                }
//                prev = i;
//            }
//        }
//        if (prev < 0) {
//            count += (m + 1) / 2;
//        } else {
//            count += (m - prev - 1) / 2;
//        }
//        return count >= n;



        int prev = -1;
        for(int i =0;i<m;i++){
            if(flowerbed[i]==1){
                if(prev<0){
                    count += i/2;
                }
                else {
                    count += (i-prev-2)/2;
                }
                if(count>=n)
                    return true;
                prev = i;
            }
        }
        if(prev<0)
            count += (m+1)/2;
        else
            count += (m-prev-1)/2;
        return count>=n;
    }
}
