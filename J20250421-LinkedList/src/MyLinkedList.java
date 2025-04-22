import java.lang.management.LockInfo;
import java.util.List;

public class MyLinkedList implements ILink{

    public class ListNode{
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;
    public ListNode last;
    @Override
    public void addFirst(int data) {
        ListNode cur = new ListNode(data);
        //没有节点
        if (this.head == null) {
            this.head = cur;
            this.last = cur;
            return;
        }
        //有节点
        cur.next = this.head;
        this.head.prev = cur;
        this.head = cur;
    }

    @Override
    public void addLast(int data) {
        ListNode cur = new ListNode(data);
        //链表为空的情况
        if (this.head == null) {
            this.head = cur;
            this.last = cur;
        }else {
            this.last.next = cur;
            cur.prev = this.last;
            this.last = cur;
        }
    }

    @Override
    public void addIndex(int index, int data) {
        //判断index合法性
        if (index < 0 || index > size()) {
            System.out.println("index位置不合法");
            return;
        }
        ListNode cur = this.head;
        if (index == 0 ) {
            addFirst(data);
            return;
        }else if (index == size()) {
            addLast(data);
            return;
        }else {
            ListNode add = new ListNode(data);
            while (index != 0) {
                cur = cur.next;
                index--;
            }
            add.next = cur;
            cur.prev.next = add;
            add.prev = cur.prev;
            cur.prev = add;
        }
    }

    @Override
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        ListNode del = this.head;
        while (del.val != key) {
            del = del.next;
        }
        if (del == null) {
            return;
        }
        //头节点情况
        if (del == this.head) {
            this.head = this.head.next;
            //
            if (this.head != null) {
                this.head.prev = null;
            }
        }else {
            del.prev.next = del.next;
            //尾结点情况
            if (del.next == null) {
                last = del.prev;
            }else {
                del.next.prev = del.prev;
            }
        }

    }

    @Override
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            ListNode curN = cur.next;
            if (cur.val == key) {
                //头
                if (cur.prev == null) {
                    this.head = cur.next;
                } else if (cur.next == null) {
                    cur.prev.next = null;//尾
                    return;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }

            }
            cur = curN;
        }
    }

    @Override
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    @Override
    public void clear() {
        ListNode cur = this.head;
        while (cur != null){
            ListNode curN = cur.next;
            cur.next = null;
            cur.prev = null;
            cur = curN;
        }
        this.head = null;
        this.last = null;
    }

    @Override
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
