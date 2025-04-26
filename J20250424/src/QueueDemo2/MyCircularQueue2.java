package QueueDemo2;

/**
 * 标记法
 */
public class MyCircularQueue2 {
    public int[] elem;
    public int front;
    public int rear;
    boolean isFull = false;

    public MyCircularQueue2(int k) {
        elem = new int[k];
    }
    public boolean enQueue (int val) {
        if (isFull()) {
            return false;
        }
        elem[rear] = val;
        rear = (rear+1) % elem.length;
        if (rear == front) {
            isFull = true;
        }
        return true;
    }

    public boolean deQueue(){
        if (isEmpty()) {
            return false;
        }
        front = (front+1) % elem.length;
        isFull = false;
        return true;
    }

    private boolean isEmpty() {
        return front == rear && isFull == false;
    }
    private boolean isFull() {
        return isFull;
    }
}
