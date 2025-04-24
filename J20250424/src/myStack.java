import java.util.Arrays;

public class myStack<E> {
    public Object[] elem;
    int usedSize = 0;
    public static final int DEFAULT_CAPACITY = 5;

    public myStack() {
        elem = new Object[DEFAULT_CAPACITY];
    }

    public void push (E val) {
        if (isFull()) {
            Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize] = val;
        usedSize++;
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    public E pop () {
        if (isEmpty()) {
            return null;
        }
        E ret = (E)elem[usedSize-1];
        usedSize--;
        return ret;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return (E)elem[usedSize-1];
    }
}
