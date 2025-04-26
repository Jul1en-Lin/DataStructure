package QueueDemo2;

public class Queue {
    //双向链表实现队列
    public static class ListNode{
        ListNode next;
        ListNode prev;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }
    ListNode front;
    ListNode last;
    int size = 0;

    public void offer(int e) {
        //入队用尾插
        ListNode listNode = new ListNode(e);
        if (front == null) {
            front = listNode;
            last = listNode;
        }else {
            last.next = listNode;
            last = last.next;
            last.prev = listNode;
        }
        size++;
    }

    public int poll() {
        //出对是从头出并删除
        int ret = front.val;
        if (front == null) {
            return -1;
        }else if (front.next == null) {
            front = null;
            last = null;
        }else {
            front = front.next;
            front.prev = null;
        }
        size--;
        return ret;
    }

    public int peek() {
        if (front == null) {
            return -1;
        }
        int ret = front.val;
        return ret;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return front == null;
    }
}