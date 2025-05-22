import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /*public ListNode addTwoNumbers(ListNode root1, ListNode root2) {
        ListNode cur1 = root1;
        ListNode cur2 = root2;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int count1 = 0;
        int count2 = 0;
        while(cur1 != null) {
            stack1.push(cur1.val);
            cur1 = cur1.next;
            count1++;
        }
        while(cur2 != null) {
            stack2.push(cur2.val);
            cur2 = cur2.next;
            count2++;
        }
        double sum1 = -1;
        double sum2 = -1;
        while(!stack1.isEmpty()) {
            double tmp = stack1.pop();
            double ret = Math.pow(10,count1);
            sum1 += tmp * ret;
            count1--;
        }
        while(!stack2.isEmpty()) {
            double tmp = stack2.pop();
            double ret = Math.pow(10,count2);
            sum2 += tmp * ret;
            count2--;
        }
        double twoNum = sum1 + sum2;
        Queue<Integer> queue = new LinkedList<>();
        while(twoNum != 0) {
            int tmp = (int)twoNum % 10;
            twoNum = twoNum / 10;
            queue.offer(tmp);
        }
        ListNode root = new ListNode();
        if(queue.peek() == null) {
            return null;
        }
        root.val = queue.poll();
        ListNode p = root;
        ListNode pre = p;
        while(!queue.isEmpty()) {
            p = new ListNode();
            p.val = queue.poll();
            pre.next = p;
            pre = p;
        }
        return root;
    }*/ //error

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //哨兵节点
        ListNode pre = new ListNode();
        ListNode cur = pre;
        //标记进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            int ret = sum % 10;
            cur.next = new ListNode(ret);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;

    }
}
