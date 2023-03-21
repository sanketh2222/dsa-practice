package advanced;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int minValue = Integer.MAX_VALUE;

    public void push(int x) {
        if (x < minValue) {
            minStack.push(x);
            minValue = x;
        }

        stack.push(x);

    }

    public void pop() {
        if (!stack.isEmpty()) {
            int popedValue = stack.pop();

            if (popedValue == minStack.peek()) {
                minStack.pop();
                minValue = minStack.isEmpty() ?  Integer.MAX_VALUE : minStack.peek();
            }
        }

    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(-2);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }
}
