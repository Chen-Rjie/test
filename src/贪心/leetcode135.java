package 贪心;
/*
老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
你需要按照以下要求，帮助老师给这些孩子分发糖果：
每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？
输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 */
public class leetcode135 {
    public int candy(int[] ratings) {
        int res = ratings.length;
        int[] count = new int[res];
        for (int i=0;i<res;i++)
        {
            count[i] = 1;
        }
        for(int i=1;i< ratings.length;i++){
            if(ratings[i-1]<ratings[i]){
                count[i] = count[i-1]+1;
            }
        }
        res = 0;
        for(int j= ratings.length-2;j>=0;j--){
            if(ratings[j]>ratings[j+1]){
                count[j] = Math.max(count[j+1]+1,count[j]);
            }
            res+=count[j];
        }
        res += count[ratings.length-1];
//        res=0;
//        for(int j=0;j< count.length;j++){
//
//        }
        return res;
    }
}
