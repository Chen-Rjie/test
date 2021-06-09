package 贪心;
//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
/*输入:
num = "1432219", k = 3
输出: "1219"
解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 */
import java.util.*;
public class leetcode402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
//        Stack<Character> tmp = new Stack<>();
        Deque<Character> deque = new LinkedList<>();
        int len1 = num.length();
        if(len1==k)
            return "0";
        for(int i=0;i<len1;i++) {
            char now = num.charAt(i);
            while (!deque.isEmpty() && k > 0) {
                if (now < deque.peekLast()) {
                    deque.pollLast();
                    k--;
                } else {
                    break;
                }
            }
            if(deque.isEmpty()&&now=='0')
                continue;
            deque.offerLast(now);
//            if (flag == 0) {
//                stack.push(now);
//            } else {
//                if (now != '0')
//                    stack.push(now);
//                else {
//                    if(!stack.isEmpty()){
//                        stack.push(now);
//                    }
//                }
//            }
        }
        while (k>0&&!deque.isEmpty()){
            deque.pollLast();
            k--;
        }
        if(deque.isEmpty())
            return "0";
        StringBuffer res = new StringBuffer();
        while(!deque.isEmpty()){
            res.append(deque.pollFirst());
        }
        String tm = res.toString();
        if(tm.equals(""))
            return "0";
        return tm;
    }

    public static void main(String[] args) {
        String ts  = "10200";
        int k = 1;
        String res = new leetcode402().removeKdigits(ts,k);
    }
}
