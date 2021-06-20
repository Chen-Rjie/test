package 双指针;

/**
 * Created by Chen
 * 2021/6/13 21:34
 */
/*
盛水最多的容器
 */
public class leetcode11 {
    //双指针 在左边界小于右边界的情况下，移动右边界不可能产生最大值
    public int maxArea(int[] height) {
        int len1 = height.length;
        int left = 0,right = len1-1;
        int maxVal = 0;
        while (left<right){
            int minH = Math.max(height[left],height[right]);
            maxVal = Math.max(maxVal,minH*(right-left));
            if(height[left]<height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return maxVal;
    }
}
