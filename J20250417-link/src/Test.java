public class Test {
    public static MySingleList.ListNode mergeTwoLists(MySingleList.ListNode headA, MySingleList.ListNode headB) {
        MySingleList.ListNode tmp = new MySingleList.ListNode(-1);//随意值 哨兵节点
        MySingleList.ListNode tmpHead = tmp;
        while (headA != null && headB != null) {
            if (headB.val < headA.val) {
                tmpHead.next = headB;
                tmpHead = tmpHead.next;
                headB = headB.next;
            }else {
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
    public static void main(String[] args) {
        
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(12);
        mySingleList.addLast(40);
        mySingleList.addLast(51);
        mySingleList.addLast(78);
        mySingleList.display();

        MySingleList mySingleList2 = new MySingleList();
        mySingleList2.addLast(10);
        mySingleList2.addLast(22);
        mySingleList2.addLast(35);
        mySingleList2.addLast(68);
        mySingleList2.display();

        System.out.println("========");
        MySingleList.ListNode ret = mergeTwoLists(mySingleList.head, mySingleList2.head);
        mySingleList2.display(ret);
    }
    public static void main3(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(12);
        mySingleList.addLast(23);
        mySingleList.addLast(23);
        mySingleList.addLast(12);
        mySingleList.display();
        System.out.println(mySingleList.chkPalindrome());
    }
    public static void main2(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(12);
        mySingleList.display();
        System.out.println("=========");
        MySingleList.ListNode middleNode = mySingleList.middleNode();
        System.out.println(middleNode.val);
    }
    public static void main1(String[] args) {
        MySingleList mySingleList = new MySingleList();
        /*mySingleList.createList();
        mySingleList.display();
        System.out.println("========");
        mySingleList.addFirst(12);
        mySingleList.display();
        System.out.println("========");
        mySingleList.addLast(89);
        mySingleList.addLast(90);
        mySingleList.display();*/
        mySingleList.addFirst(12);
        mySingleList.addFirst(23);
        mySingleList.addFirst(34);
        mySingleList.addLast(45);
        mySingleList.addLast(56);
        mySingleList.display();
        mySingleList.remove(12);
        mySingleList.display();
    }
}
