import javax.crypto.spec.PSource;
import javax.swing.tree.TreeNode;
import java.util.*;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode left;
        ListNode right;
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

    /*public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
                queue.poll();
            }else {
                break;
            }
        }
        //判断队列里面是否全是空
        while (!queue.isEmpty()) {
            TreeNode ret = queue.poll();
            if (ret != null) {
                return false;
            }
        }
        return true;
    }*/




    /*public static void main(String[] args) {
        throw new 瓶盖();
        destroy();
        System.out.println("对不住了兄弟");
        apologize();
        if (apologize()) {
            System.out.println("你这态度那还说啥了");
        }
        switch () {
            case drink():
                System.out.println("去我后备箱拿瓶酒");
                break;
            case smoke():
                System.out.println("去我后备箱拿条烟");
                break;
            default:
                break;
        }
        System.out.println("你说这扯不扯");
        if(fullness()) {
            System.out.println("哥们我俩吃完先走了");
            System.out.println("把帐结了");
            compensate();
            System.out.println("兄弟");
        }
    }*/

    public ArrayList<ArrayList<ListNode>> fun1(ListNode pRoot) {
        ArrayList<ArrayList<ListNode>> ret = new ArrayList<>();
        if (pRoot == null) {
            return ret;
        }
        boolean flg = true;
        Queue<ListNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<ListNode> tmp = new ArrayList<>();
            while (size != 0) {
                ListNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                tmp.add(cur);
                size--;
            }
            if (flg) {
                flg = false;
            }else {
                Collections.reverse(tmp);
                flg = true;
            }
            ret.add(tmp);
        }
        return ret;
    }
    //判断是否回文链表：1 2 3 2 1    12  23  34  34  23  12
    public boolean chkPalindrome(ListNode A) {
        int[] array = new int[1_000];
        ListNode cur = A;
        int size = 0;
        while (cur != null) {
            array[size++] = cur.val;
            cur = cur.next;
        }

        int leftIndex = 0;
        int rightIndex = array.length-1;
        while (leftIndex <= rightIndex) {
            if (array[leftIndex++] != array[rightIndex--]) {
                return false;
            }
        }
        return true;
    }

    public boolean chkPalindrome2(ListNode A) {
        if (A == null) {
            return false;
        }
        if (A.next == null) {
            return true;
        }
        ListNode mid = middleNode(A);
        ListNode cur = mid.next;
        while (cur != null) {
            ListNode fast = cur.next;
            cur.next = mid;
            mid = cur;
            cur = fast;
        }

        while (A.val == mid.val) {
            if (A == mid) {
                return true;
            }
            if (A.next == mid) {
                return true;
            }
            A = A.next;
            mid = mid.next;
        }
        return false;
    }

    private ListNode middleNode(ListNode A) {
        ListNode fast = A;
        ListNode slow = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main3(String[] args) {
        System.out.println("今天摸个鱼，好累，期末了要复习好多科，Java原谅我");
    }

    public static void main4(String[] args) {
        System.out.println("今天复了一天的电路分析基础，希望过过过");
        System.out.println("先把Java小朋友打入冷宫");
    }

    public static void main5(String[] args) {
        System.out.println("哈哈哈哈哈今天考完电路分析了，但是明天还要考电路实验。。。又要去复习了。");
    }

    public static void main6(String[] args) {
        System.out.println("一天不写代码感觉脑子生锈了。。。糟糕的四六级考试快来吧我不想复习了/(ㄒoㄒ)/~~");
    }

    public static void main(String[] args) {
        System.out.println("明天考四级 考完我就自由啦能学MySQL啦哈哈哈哈哈哈");
    }
}
