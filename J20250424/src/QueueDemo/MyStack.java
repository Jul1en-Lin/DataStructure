package QueueDemo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队实现栈
 */
class MyStack {

    public Queue<Integer> qu1;
    public Queue<Integer> qu2;

    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    /**
     * 添加非空队列中,两者为空进qu1
     * @param x
     */
    public void push(int x) {
        /*if (empty()){
            qu1.offer(x);
        }
        if (!qu1.isEmpty()) {
            qu1.offer(x);
        }else if (!qu2.isEmpty()){
            qu2.offer(x);
        }*/

        if (!qu2.isEmpty()) {
            qu2.offer(x);
        }else {
            qu1.offer(x);
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        if(qu1.isEmpty()) {
            while (qu2.size()-1 != 0) {
                qu1.offer(qu2.poll());
            }
            return qu2.poll();
        }else {
                while (qu1.size()-1 != 0) {
                    qu2.offer(qu1.poll());
                }
                return qu1.poll();
            }
    }

    public int peek(){
        if (empty()) {
            return -1;
        }
        int tmp;
        if (!qu1.isEmpty() && qu2.isEmpty()) {
            while (qu1.size()-1 != 0){
                qu2.offer(qu1.poll());
            }
            tmp = qu1.poll();
            qu2.offer(tmp);
        }else {
            while (qu2.size()-1 != 0){
                qu1.offer(qu2.poll());
            }
            tmp = qu2.poll();
            qu1.offer(tmp);
        }
        return tmp;
    }
    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}