package queue;

import java.util.Stack;
//Build queue using stacks
public class MyQueue<T> {
    private Stack<T> stack1; // For enqueue
    private Stack<T> stack2; // For dequeue

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T item) {
        stack1.push(item);
    }

    public T dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? null : stack2.pop();
    }

    public T peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? null : stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeue: " + queue.dequeue()); // Output: 1
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 2
        System.out.println("Peek: " + queue.peek()); // Output: 3
    }
}
