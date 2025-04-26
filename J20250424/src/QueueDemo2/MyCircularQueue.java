package QueueDemo2;

/**
 * 浪费一个空间法
 */
public class MyCircularQueue {
    public int[] elem;
    public int front;
    public int rear;

    public MyCircularQueue(int k) {
        elem = new int[k+1];
    }

    /**
     * 入队列
     */
    public boolean enQueue (int val) {
        if (isFull()) {
            return false;
        }else {
            elem[rear] = val;
            rear = (rear + 1) % elem.length;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }else {
            front = (front + 1) % elem.length;
            return true;
        }
    }

    /**
     * 返回队头元素
     * @return
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elem[front];
    }

    /**
     * 注意rear在0处的位置
     * @return
     */
    public int rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = elem.length-1;
        if (rear == 0) {
            return elem[index];
        }else {
            return elem[rear-1];
        }
    }

    private boolean isEmpty(){
        return rear == front;
    }

    private boolean isFull(){
        if ((rear+1) % elem.length == front) {
            return true;
        }
        return false;
    }
}
