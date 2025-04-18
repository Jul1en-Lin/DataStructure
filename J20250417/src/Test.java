public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(12);
        mySingleList.addLast(23);
        mySingleList.addLast(34);
        mySingleList.addLast(34);
        mySingleList.addLast(34);
        mySingleList.addLast(45);
        mySingleList.addLast(56);
        mySingleList.removeAllKey(34);
        mySingleList.display();
        System.out.println("=========");
        mySingleList.clear();
        mySingleList.display();
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
