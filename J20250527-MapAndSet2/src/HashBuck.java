import java.util.Arrays;

public class HashBuck {
    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public int useSize;
    public Node[] array;
    public static final double LOAD_FACTOR = 0.75;


    public HashBuck() {
        array = new Node[16];
    }

    //尾插版
    public void push(int key,int val) {
        int index = key % array.length;
        Node cur = array[index];

        if (cur == null) {
            array[index] = new Node(key,val);
            useSize++;
            return;
        }
        Node prev = null;
        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
        //尾插
        prev.next = new Node(key, val);
        useSize++;

        if(calcLoadFactor() >= LOAD_FACTOR){
            resize();
        }
    }
    //头插版
    public void push2(int key,int val) {
        int index = key % array.length;
        Node cur = array[index];
        //检查有无重复的key
        while (cur != null) {
            if(cur.key == key) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        Node newNode = new Node(key, val);
        newNode.next = array[index];
        array[index] = newNode;
        useSize++;

        //扩容
        if(calcLoadFactor() >= LOAD_FACTOR){
            resize();
        }
    }

    private double calcLoadFactor() {
        return useSize*1.0 / array.length ;
    }

    private void resize() {
        //二次哈希
        Node[] arr = new Node[array.length*2];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                //头插法
                int index = cur.key % arr.length;
                Node curN = cur.next;
                cur.next = arr[index];
                arr[index] = cur;
                cur = curN;
            }
        }
        array = arr;
    }
    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

}
