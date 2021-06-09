import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class leetcode84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int[] newheight = new int[heights.length+1];
        System.arraycopy(heights,0,newheight,0,heights.length);
        for(int i=0;i< newheight.length;i++)
        {
            while(!stack.isEmpty()&&newheight[stack.peek()]>newheight[i])
            {
                int top = stack.pop();
                maxArea = Math.max(maxArea,newheight[top]*(stack.isEmpty()?i:(i-stack.peek()-1)));
            }
            stack.push(i);
        }
        return maxArea;
    }
    public static void main(String[] args)
    {

        int[] ts = new int[]{2,1,5,6,2,3};
//        ConcurrentHashMap
        int res = new leetcode84().largestRectangleArea(ts);
    }

}
