import java.lang.management.LockInfo;

public class MySingleList implements ILink{
    static class ListNode{
        //数据
        public int val;
        //节点的引用
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;

    public void createList(){
        ListNode listNode1 = new ListNode(11);
        ListNode listNode2 = new ListNode(22);
        ListNode listNode3 = new ListNode(33);
        ListNode listNode4 = new ListNode(44);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        this.head = listNode1;
    }
    @Override
    public void addFirst(int data) {
        ListNode ret = new ListNode(data);
        /*if (head == null) {
            return;
        }*/
        ret.next = this.head;
        this.head = ret;
    }

    @Override
    public void addLast(int data) {
        ListNode ret = new ListNode(data);
        if (this.head == null) {
            this.head = ret;
            return;
        }
        //找到尾巴
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = ret;
    }

    @Override
    public void addIndex(int index, int data) {
        checkPos(index);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode ret = new ListNode(data);
        ListNode cur = findPos(index);
        ret.next = cur.next;
        cur.next = ret;
    }

    private ListNode findPos(int index) {
        ListNode cur = this.head;
        while (index -1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    private void checkPos(int index) {
        if (index < 0 || index > size()) {
            throw new CheckPosException("存放下标错误: "+index);
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
            System.out.println("链表为空");
            return;
        }
        //删除的是头节点
        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        //其他节点
        ListNode prv = searchPrvPos(key);
        if (prv == null) {
            System.out.println("没有你要删除的数字："+key);
            return;
        }
        ListNode del = prv.next;
        prv.next = del.next;
    }

    private ListNode searchPrvPos(int key) {
        ListNode prv = this.head;
        while (prv.next != null){
            if (prv.next.val == key) {
                return prv;
            }
            prv = prv.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(int key) {
        if (this.head == null) {
            System.out.println("链表为空");
            return;
        }
        while (this.head.val == key) {
            this.head = head.next;
        }
        ListNode cur = this.head;
        ListNode tmp = cur.next;
        while (tmp != null) {
            if (tmp.val == key) {
                cur.next = tmp.next;
                tmp = tmp.next;
            }else {
                cur = tmp;
                tmp = tmp.next;
            }
        }
    }

    @Override
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void clear() {
        while (this.head != null) {
            ListNode tmp = this.head;
            this.head.val = 0;
            this.head.next = null;
            this.head = tmp;
        }
        this.head = null;
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

    //翻转列表
    public ListNode reverseList(){
        //判断列表是否为空
        if (head == null) {
            return null;
        }
        //判断是否只有一个节点
        if (head.next == null) {
            return head;
        }
        //多个节点
        ListNode cur = this.head;
        ListNode curN = cur.next;
        while (cur != null) {
            cur.next = this.head;
            this.head = cur;
            cur = curN;
            curN = curN.next;
        }
        return this.head;
    }
    //重载display方法
    public void display(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //找中间节点(只遍历一遍)
    public ListNode middleNode(){
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null){
        //while (fast.next != null && fast != null) 空指针异常 {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //找中间节点(size/2普通)
    public ListNode middleNode2(){
        ListNode cur = this.head;
        int len = size();
        int ret = len / 2;
        for (int i = 0; i < ret; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //找倒数第K个节点的值(只遍历一遍)
    public int kthToLast(int k){
        //判断K节点合法性
        if (k <= 0) {
            return -1;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        //fast 走k-1步 与 slow 保持差值
        for (int i = 0; i < k - 1 ; i++) {
            fast = fast.next;
            if (fast == null) {
                return -1;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    //判断是否回文 12 23 34 23 12 即为回文
    public boolean chkPalindrome(){
        if (this.head == null) {
            return false;
        }

        ListNode mid = middleNode();
        //从中间节点开始翻转
        ListNode cur = mid.next;
        while (cur != null) {
            ListNode fast = cur.next;
            cur.next = mid;
            mid = cur;
            cur = fast;
        }
        //判断是否回文
        while (this.head.val == mid.val) {
            //奇数
            if (this.head == mid) {
                return true;
            }
            //偶数
            if (this.head.next == mid) {
                return true;
            }
            this.head = this.head.next;
            mid = mid.next;
        }
        return false;
    }

    //将两个有序链表合并成一个新的有序链表并返回，新链表是通过拼接给定的两个链表的所有节点组成的
    public ListNode mergeTwoLists(ListNode headA,ListNode headB) {
        ListNode tmp = new ListNode(-1);//随意值 哨兵节点
        ListNode tmpHead = tmp.next;
        while (headA != null && headB != null) {
            if (headB.val < headA.val) {
                tmpHead.next = headB;
                tmpHead = tmpHead.next;
                headB = headB.next;
            }
            if (headB.val > headA.val) {
                tmpHead.next = headA;
                tmpHead = tmpHead.next;
                headA = headA.next;
            }
        }
        if (headB == null) {
            tmpHead.next = headA;
        }
        if (headA == null) {
            tmpHead.next = headB;
        }
        return tmp.next;
    }
}
