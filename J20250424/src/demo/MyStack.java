package demo;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    public Queue<Integer> qu1;
    public Queue<Integer> qu2;

    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(int x) {
        if (empty()){
            qu1.offer(x);
        }else {
            if(qu1.isEmpty()) {
                qu2.offer(x);
            }else if(qu2.isEmpty()){
                qu1.offer(x);
            }
        }
    }

    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}