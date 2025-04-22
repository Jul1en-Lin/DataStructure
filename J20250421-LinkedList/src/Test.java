public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(123);
        myLinkedList.addLast(12);
        myLinkedList.display();
        System.out.println("=====");
        myLinkedList.removeAllKey(12);
        myLinkedList.display();

    }

}
