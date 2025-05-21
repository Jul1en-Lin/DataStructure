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
    public ListNode addTwoNumbers(ListNode root1, ListNode root2) {
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

        double sum1 = 0;
        double sum2 = 0;
        while(!stack1.isEmpty() && count1 != 0) {
            double tmp = stack1.pop();
            double ret = Math.pow(10,count1);
            sum1 = tmp * ret;
            count1--;
        }

        while(!stack2.isEmpty() && count2 != 0) {
            double tmp = stack2.pop();
            double ret = Math.pow(10,count2);
            sum2 = tmp * ret;
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
        if(queue.poll() == null) {
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
    }
}
