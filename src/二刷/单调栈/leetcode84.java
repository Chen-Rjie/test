package 二刷.单调栈;

import java.util.Map;
import java.util.Stack;

/*
柱状图中的最大矩形  递增栈
 */
public class leetcode84 {
    public static void main(String[] args) {
        int[] ts = new int[]{2,1,2};
        int res = new leetcode84().largestRectangleArea(ts);
        System.out.println(res);
    }
//    public int largestRectangleArea(int[] heights) {
//        Stack<Integer> stack = new Stack<>();
//        int lenh = heights.length;
//        int res = 0;
//        for(int i=0;i<lenh;i++){
//            if (!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
//                int index = 0;
//                while (!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
//                    index = stack.pop();
//                    if(stack.isEmpty()){
//                        res = Math.max(i*)
//                    }
//                    res = Math.max((i-index)*heights[index],res);
//                }
////                if(stack.isEmpty()){
////                    res = Math.max(res,i*heights[i]);
////                }else {
////                    res = Math.max(res,heights[i]*(i-index));
////                }
////
//////                while (heights[stack.peek()]>heights[i]){
//////                    stack.pop();
//////                }
//            }
//            stack.push(i);
//        }
//        while (!stack.isEmpty()){
//            int index = stack.pop();
//            res = Math.max((lenh-index)*heights[index],res);
//        }
//        return res;
//
//    }
public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int lenh = heights.length;
    int res = 0;
    for(int i=0;i<lenh;i++){
        if (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
            int index;
            while (!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                index = stack.pop();
                res = Math.max(heights[index]*(stack.isEmpty()?i:i-stack.peek()-1),res);
            }

//                while (heights[stack.peek()]>heights[i]){
//                    stack.pop();
//                }
        }
        stack.push(i);
    }
    while (!stack.isEmpty()){
        int index = stack.pop();
        res = Math.max((lenh-index)*heights[index],res);
    }
//    for(int i=0;i<lenh;i++){
//        res = Math.max((lenh-i)*heights[i],res)
//    }
    return res;

}
}
