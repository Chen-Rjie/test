package 二刷.排序;

import sun.nio.cs.ext.IBM037;

import java.util.HashMap;
import java.util.Map;

/**
 * DATE: 2021/5/30
 * Author: (Chen)
 */
/*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
 */
public class leetcode75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0,right = n-1;
        for(int i=0;i<n;i++){
            if(i==right)
                break;
            while (i<right&&nums[i]==2){
                int tmp = nums[i];
                nums[i] = nums[right];
                nums[right] = tmp;
                right--;
            }
            if(nums[i]==0){
                int tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
                left++;
            }
        }StringBuilder str = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        map.put('2',2);
        map.put('3',3);
        for(int num:map.values())
            System.out.println(num);
        System.out.println(map.values());}

    public static void main(String[] args) {
        new leetcode75().sortColors(new int[]{2,3});
        float s = 3.1111f;
        System.out.println();
        double s2 = 3/2;
        System.out.println(s2);
    }
}
