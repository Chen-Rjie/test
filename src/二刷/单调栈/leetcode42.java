package 二刷.单调栈;

import java.util.Stack;

/**
 * 接雨水
 * 求第一个比它大的 用递减栈 第一个比它小的用递增栈
 */
public class leetcode42 {
    public static void main(String[] args) {

    }
//    public int trap(int[] height) {
//        Stack<Integer> stack = new Stack<>();
//        int lens = height.length;
//        int res = 0;
//        for(int i=0;i<lens;i++){
//            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
//                int top = stack.pop();
//                if(stack.isEmpty()){
//                    break;
//                }
//                int dis = i-stack.peek()-1;
//                res += dis*(Math.min(height[i],height[stack.peek()])-height[top]);
//            }
//            stack.push(i);
//        }
//        return res;
//    }

    //动态规划
    public int trap(int[] height) {
        //求两边最大高度的最大高度
        int lenH = height.length;
        int[] left = new int[lenH];
        int[] right = new int[lenH];
        for(int i = 0;i<lenH;i++){
            if(i==0){
                left[i] = height[i];
                right[lenH-1-i] = height[lenH-1];
            }
            else {
                right[lenH-1-i] = Math.max(right[lenH-i],height[lenH-i-1]);
                left[i] = Math.max(left[i-1],height[i]);
            }
        }
        int sum = 0;
        for(int i=1;i<height.length-1;i++){
            sum += Math.min(left[i],right[i])-height[i];
        }
        return sum;

    }
}
