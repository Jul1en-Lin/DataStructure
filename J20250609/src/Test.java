public class Test {
    static class ListNode{
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;

    public boolean isPalindrome(ListNode head) {
        int[] array = new int[100000];
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            array[size++] = cur.val;
            cur = cur.next;
        }
        int front = 0;
        int last = size-1;
        while (array[front] == array[last] && front < last) {
            front++;
            last--;
        }
        if (front >= last) {
            return true;
        }
        return false;
    }
}
