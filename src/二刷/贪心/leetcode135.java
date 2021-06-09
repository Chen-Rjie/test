package 二刷.贪心;

import java.util.Arrays;

/**
 * DATE: 2021/5/28
 * Author: (Chen)
 */
/*
分发糖果
输入：[1,0,2]
输出：5
老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
你需要按照以下要求，帮助老师给这些孩子分发糖果：
每个孩子至少分配到 1 个糖果。
评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。

著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 */
public class leetcode135 {
    public int candy(int[] ratings) {
        //两次遍历  同时满足左边与右边的要求
        int n = ratings.length;
        int[] count = new int[n];
//        for(int i=0;i<n;i++){
//            count[i] = 1;
//        }
        Arrays.fill(count,1);
        for(int i=1;i<n;i++){
            count[i] = ratings[i]>ratings[i-1]?count[i-1]+1:1;
        }
        int res = 0;
        for(int j=n-2;j>=0;j--){
            if(ratings[j]>ratings[j+1]){
                count[j] = Math.max(count[j+1]+1,count[j]);
            }
            res += count[j];
        }
        res += count[n-1];
        return res;
    }
    //方法二  找递增和递减序列就可以
    public int candy1(int[] ratings) {
        //要统计连在一起的上升子序列和下降子序列的长度的大小，若下降子序列较长，则上升子序列的最后一列还要加，每多一个下降元素，最后一列就要多加1
        int pre = 1,res = 1,inc=1,dec=0;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                pre = pre+1;
                res += pre;
                inc = pre;
                dec = 0;
            }
            else if(ratings[i]== ratings[i-1]){
                pre = 1;//每次碰到连续相等就将连续上升序列置为1
                inc = pre;
                res += pre;
                dec = 0;
            }
            else {
                dec++;//开始下降
                if(dec==inc){
                    dec++;//实际上是加到左边最高的列上面了，后面每多一列就要多加上一个1
                }
                res += dec;
                pre = 1;
            }
        }
        return res;
    }
}
