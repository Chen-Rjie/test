package 设计;
import java.util.*;
public class leetcode232 {


}
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        this.stack1.push(x);
//        this.stack2.push(this.stack1.pop());

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!this.stack1.isEmpty()){
            this.stack2.push(this.stack1.pop());
        }
        int res =  this.stack2.pop();
        while (!this.stack2.isEmpty()){
            this.stack1.push(this.stack2.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        while (!this.stack1.isEmpty()){
            this.stack2.push(this.stack1.pop());
        }
        int res =  this.stack2.peek();
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
