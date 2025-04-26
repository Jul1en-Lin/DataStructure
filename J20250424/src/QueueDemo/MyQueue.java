package QueueDemo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个栈实现队
 */
public class MyQueue {
    public Deque<Integer> st1;
    public Deque<Integer> st2;

    public MyQueue() {
        st1 = new LinkedList<>();
        st2 = new LinkedList<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }else{
            while(st1.size() != 0) {
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }

    public int peek() {
        if (empty()) {
            return -1;
        }else{
            while(st1.size() != 0) {
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }

    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}
