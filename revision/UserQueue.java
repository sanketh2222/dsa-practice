package revision;

import java.util.Stack;

public class UserQueue {
    
    /** Initialize your data structure here. */
    static Stack<Integer> stk1, stk2;

    UserQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    /** Push element X to the back of queue. */
    static void push(int X) {
        stk1.push(X);
    }

    /** Removes the element from in front of queue and returns that element. */
    static int pop() {
        while (!stk1.empty())
            stk2.push(stk1.pop());
        int top = stk2.pop();
        while (!stk2.empty())
            stk1.push(stk2.pop());
        return top;
    }

    /** Get the front element of the queue. */
    static int peek() {
        while (!stk1.empty())
            stk2.push(stk1.pop());
        int top = stk2.peek();
        while (!stk2.empty())
            stk1.push(stk2.pop());
        return top;
    }

    /** Returns whether the queue is empty. */
    static boolean empty() {
        return stk1.empty();
    }
}
