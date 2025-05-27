public class HashBuck2<K,V> {
    static class Node<K,V> {
        public K key;
        public V val;
        public Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    public int useSize;
    public Node<K, V>[] array;
    public static final double LOAD_FACTOR = 0.75;

    public HashBuck2() {
        array = (Node<K, V>[]) new Node[16];
    }

    public void push(K key,V val) {
        int hash = key.hashCode();
        int index = hash % array.length;

        Node<K,V> cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        Node<K, V> node = new Node<>(key, val);
        node.next = array[index];
        array[index] = node;
        useSize++;

        if (calcLoadFactor() >= LOAD_FACTOR) {
            resize();
        }
    }

    private double calcLoadFactor() {
        return useSize*1.0 / array.length;
    }

    private void resize() {
        Node<K,V>[] newArray = new Node[array.length*2];
        for (int i = 0; i < array.length; i++) {
            Node<K,V> cur = array[i];
            while (cur != null) {
                Node<K,V> curN = cur.next;
                int index = cur.key.hashCode() % array.length;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curN;
            }
        }
        array = newArray;
    }

    public V get(K key) {
        int index = key.hashCode() % array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }
}
