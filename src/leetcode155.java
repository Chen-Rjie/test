import java.util.Stack;

public class leetcode155 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack_sup = new Stack<>();
    public leetcode155() {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack_sup = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(stack_sup.isEmpty())
        {
            stack_sup.push(x);
        }
        else {
            int top = stack_sup.peek();
            if(x<top)
            {
                stack_sup.push(x);
            }
            else {
                stack_sup.push(top);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack_sup.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack_sup.peek();
    }
}
