package Stackdemo;

import java.util.Arrays;

public class MinStack {
    int [] elem;
    int usedSize = 0;

    public MinStack() {
        elem = new int[5];
    }

    public void push(int val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize] = val;
        usedSize++;
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        usedSize--;
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        int ret = elem[usedSize-1];
        return ret;
    }

    public int getMin() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        if (isEmpty()) {
            throw new RuntimeException();
        }
        int min = elem[0];
        for (int i = 0; i < usedSize; i++) {
            if (elem[i] < min) {
                min = elem[i];
            }
        }
        return min;
    }

    private boolean isFull() {
        return usedSize == elem.length;
    }

    private boolean isEmpty() {
        return usedSize == 0;
    }
}
