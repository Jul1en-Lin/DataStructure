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
        ListNode prv = searchPrvPos(key);
        ListNode del = prv.next;
        prv.next = del.next;

        if (this.head == null) {
            this.head = head.next;
        }
    }

    private ListNode searchPrvPos(int key) {
        ListNode prv = this.head;
        while (prv.next.val != key){
             prv = prv.next;
        }
        return prv;
    }

    @Override
    public void removeAllKey(int key) {

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
