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

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node() {

        }
    }

    /**
     * 在节点值唯一时可以工作，如果包含重复值则不能用
     * @param head
     * @return 拷贝后的头节点
     */
    public Node copyRandomList(Node head) {
        if (head != null) return null;
        //哨兵节点
        Node pre = new Node();
        Node copyHead = new Node(head.val);
        Node node = copyHead;
        pre.next = copyHead;
        Node cur = new Node();
        if (head.next == null) {
            copyHead.next = null;
        }else {
            cur = head.next;
        }
        //遍历复制val
        while (cur != null) {
            Node newNode = new Node(cur.val);
            node.next = newNode;
            node = node.next;
            cur = cur.next;
        }
        cur = head;
        node = copyHead;
        //找到random节点
        Node ran;
        Node copyRan;
        while (cur != null) {
            ran = cur.random;
            copyRan = copyHead;
            while (ran.val != copyRan.val && ran != null) {
                copyRan = copyRan.next;
            }
            if (ran == null) {
                node.random = null;
            }else {
                node.random = copyRan;
            }
            node = node.next;
            cur = cur.next;
        }
        return pre.next;
    }

    /**
     * 适用于任何场景的哈希表深度拷贝链表
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head){
        if (head == null) return null;
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        //第一次遍历：创造所有节点的拷贝，建立映射关系
        while (cur != null) {
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        //第二次遍历：链接next和random指针
        while (cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 返回前 k 个出现次数最多的单词
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        //统计单词频率，建立映射关系
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0) +1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer o1count = map.get(o1);
                Integer o2count = map.get(o2);
                if (o1count.equals(o2count)) {
                    //频率相同时：字典序降序（Z->A）
                    return o2.compareTo(o1);
                }else {
                    //小顶堆
                    return o1count - o2count;
                }
            }
        });
        //Top K问题
        for(String word : map.keySet()) {
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();//优先淘汰最低的且字母顺序大的
            }
        }
        //保证次数高的优先
        LinkedList<String> stack = new LinkedList<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        return stack;
    }


    public void moveZeroes(int[] nums) {
        int dest = -1;
        int cur = dest+1;
        for ( ; cur < nums.length;cur++) {
            if(nums[cur] == 0){
                swap(nums,dest+1,cur);
                dest++;
            }
        }
    }
    public void swap(int[] nums,int i,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

    }
}
