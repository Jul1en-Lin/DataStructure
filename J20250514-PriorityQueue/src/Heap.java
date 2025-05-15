import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Heap {
    public int[] elem;
    public int usedSize;

    public Heap() {
        this.elem = new int[11];
    }
    //赋值
    public void init(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

    /**
     * 创建大根堆
     */
    public void createHeap () {
        for (int parent = (usedSize-1-1)/2; parent >= 0; parent-- ) {
            siftDown(parent,usedSize);
        }
    }


    //向下调整
    private void siftDown(int parent,int usedSize) {
        int child = 2 * parent + 1;
        //判断是否有右树
        while (child < usedSize) {
            if (child + 1 < usedSize && elem[child] < elem[child+1]) {
                child = child + 1;
            }
            if (elem[parent] < elem[child]) {
                swap(elem,parent,child);
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }
    private void swap (int[] array,int parent,int child) {
        int tmp = array[parent];
        array[parent] = array[child];
        array[child] = tmp;
    }

    public void offer(int val) {
        if (ifFull()) {
            elem = Arrays.copyOf(elem,2 * elem.length);
        }
        elem[usedSize] = val;
        siftUp(usedSize);
        usedSize++;
    }

    private boolean ifFull() {
        return usedSize == elem.length;
    }

    private void siftUp(int child) {
        int parent = (child - 1) / 2;
        while (parent >= 0) {
            if (elem[child] > elem[parent]) {
                swap(elem,parent,child);
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }
    }

    //抛出堆顶元素
    public int poll() {
        if (isEmpty()){
            return -1;
        }
        int ret = elem[0];
        swap(elem,0,usedSize-1);
        siftDown(0,usedSize-1);
        usedSize--;
        return ret;
    }
    private boolean isEmpty() {
        return usedSize == 0;
    }

    public int peekHeap() {
        return elem[0];
    }

    //找数组中最小的k个数
    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];
        if(k == 0 || arr == null) {
            return ret;
        }
        //创造k个节点的大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll();
        }
        return ret;
    }

    public int[] smallestK2(int[] arr, int k) {
        int[] ret = new int[k];
        if (arr == null || k == 0) {
            return ret;
        }
        //创建小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            int val = queue.poll();
            ret[i] = val;
        }
        return ret;
    }

    public void heapSort() {
        int end = usedSize-1;
        while (end > 0) {
            swap(elem,0,end);
            siftDown(0,end);
            end--;
        }
    }
}
