package 二刷.单调栈;
/*
给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意:

num 的长度小于 10002 且≥ k。
num 不会包含任何前导零。
示例 1 :

输入: num = "1432219", k = 3
输出: "1219"
解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 */

//贪心＋单调栈
//在右边找到第一个比自己小的元素 然后删除本身，每次从最左边开始删除 这是贪心策略 优先删除高位

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class leetcode402 {
    public String removeKdigits(String num, int k) {
        int lens = num.length();
        Deque<Character> deque = new LinkedList<>();
        for(int i=0;i<lens;i++){
            char digit = num.charAt(i);
            while (!deque.isEmpty()&&k>0&&deque.peekLast()>digit){
                deque.pollLast();
                k--;
            }
            deque.addLast(digit);
        }
        while (k-->0){
            deque.pollLast();
        }
        StringBuffer stringBuffer = new StringBuffer();
        Boolean flag = true;
        while (!deque.isEmpty()){
            char digit = deque.pollFirst();
            if(digit=='0'&&flag)
                continue;
            flag = false;
            stringBuffer.append(digit);
        }
        return stringBuffer.length()==0?"0":stringBuffer.toString();
    }
}
