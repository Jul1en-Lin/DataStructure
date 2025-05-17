import java.awt.desktop.PreferencesEvent;
import java.util.Deque;
import java.util.LinkedList;

public class Sort {

    /**
     * 直接插入排序
     *  时间复杂度O(N^2)
     *  空间复杂度O(1)
     *  稳定性：稳定排序⭐
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                //如果是 >= 那就不稳定了
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            //j == -1
            array[j+1] = tmp;
        }
    }

    /**
     * 希尔排序
     *  时间复杂度O(N^1.3~N^1.5)
     *  空间复杂度O(1)
     *  稳定性：不稳定
     */
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap >= 1) {
            shell(array,gap);
            gap = gap/2;
        }
    }

    public static void shell (int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for ( ;j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    /**
     * 选择排序
     *  时间复杂度O(N^2)
     *  空间复杂度O(1)
     *  稳定性：不稳定
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
               if (array[j] < array[minIndex]) {
                   minIndex = j;
               }
            }
            swap(array,i,minIndex);
        }
    }

    private static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 堆排序
     *  时间复杂度O(N*logN)
     *  空间复杂度O(1)
     *  稳定性:稳定
     */
    public static void heapSort(int[] array) {
        int end = array.length-1;

        //创建大根堆
        for (int parent = (end-1)/2; parent >= 0; parent-- ) {
            siftDown(array,parent,array.length-1);
        }
        while (end > 0){
            swap(array,0,end);
            siftDown(array,0,end);
            end--;
        }
    }

    public static void siftDown(int[] array, int parent,int length) {
        int child = 2*parent + 1;
        while (child < length) {
            //判断是否有右树
            if (child + 1 < length && array[child] < array[child+1]) {
                child++;
            }
            if (array[child] > array[parent]) {
                swap(array,parent,child);
                parent = child;
                child = 2*parent + 1;
            }else {
                break;
            }
        }
    }

    /**
     * 冒泡排序
     *  时间复杂度O(N^2)
     *    最好情况是{1，2，3，4，5} O(N)
     *  空间复杂度O(1)
     *  稳定性:稳定
     * @param array
     */
    public static void bubbleSort(int[] array) {
        //i表示趟数
        for (int i = 0; i < array.length-1; i++) {
            boolean flg = false;//优化
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array,j,j+1);
                    flg = true;
                }
            }
            if (!flg){
                break;
            }
        }
    }

    /**
     * 快速排序（类似于二叉树的结构）
     *  找 par 排序效率：挖孔法(main) > Hoare法 > 前后指针法(简单了解即可)
     *  时间复杂度：
     *      最好情况下:O(N * logN)
     *      最坏情况下:O(N^2)
     *  空间复杂度:
     *      最好情况下：O(logN)（满二叉树）
     *      最坏情况下：O(N)（每一个都是右树）
     *  稳定性：不稳定
     * @param array
     */
    public static void quickSort(int[] array){
        //接口统一性 ---重载
        quickSort(array,0,array.length-1);
    }
    private static void quickSort(int[] array,int left,int right){
        if (left >= right) {
            return;
        }
        //优化 内置插入排序 趋于有序时减少检查的次数
        if (right - left + 1 <= 8) {
            insertSortRange(array,left,right);
            return;
        }


        //优化 采用三数取中法 找下标 使得tmp更加合理
        int index = threeMid(array,left,right);
        swap(array,index,left);

        int par = partition(array,left,right);
        quickSort(array,left,par-1);
        quickSort(array,par+1,right);
    }

    //Hoare法
    private static int partitionHoare(int[] array,int low,int high) {
        int i = low;
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            while (low < high && array[low] <= tmp) {
                low++;
            }
            swap(array,low,high);
        }
        //left == high
        swap(array,low,i);
        return low;
    }

    //挖孔法
    private static int partition(int[] array,int low,int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }

    //前后指针法
    private static int partition2(int[] array,int low,int high) {
        int prv = low;//
        int cur = low+1;//找tmp小的
        int tmp = array[low];
        while (low < high) {
            if (array[cur] < tmp && array[++prv] != array[cur]) {
                swap(array,prv,cur);
            }
            cur++;
        }
        swap(array,prv,low);
        return prv;
    }

    private static int threeMid(int[] array,int low, int high) {
        int mid = (low + high) / 2;
        if (array[low] > array[high]) {
            if (array[mid] < array[high]) {
                return high;
            }else if (array[mid] > array[low]) {
                return low;
            }else {
                return mid;
            }
        }else {
            if (array[mid] < array[low]) {
                return low;
            }else if (array[mid] > array[high]) {
                return high;
            }else {
                return mid;
            }
        }
    }

    private static void insertSortRange(int[] array,int low,int high) {
        for (int i = low + 1; i < high; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= low; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            //j == -1
            array[j+1] = tmp;
        }
    }

    /**
     * 非递归快速排序
     *  稳定性：不稳定
     * @param array
     */
    public static void quickSortNor(int[] array) {
        int start = 0;
        int end = array.length-1;
        int par = partition(array,start,end);

        Deque<Integer> stack = new LinkedList<>();
        if (par > start+1) {
            stack.push(start);
            stack.push(par-1);
        }
        if (par < end - 1) {
            stack.push(par + 1);
            stack.push(end);
        }
        while (!stack.isEmpty()){
            end = stack.poll();
            start = stack.poll();
            par = partition(array,start,end);
            if (par > start+1) {
                stack.push(start);
                stack.push(par-1);
            }
            if (par < end - 1) {
                stack.push(par + 1);
                stack.push(end);
            }
        }
    }

    /**
     * 合并排列
     *  时间复杂度O(N*logN)
     *  空间复杂度O(N)
     *  稳定性:稳定
     * @param array
     */
    public static void mergeSort(int[] array) {
        mergeSortChild(array,0,array.length-1);
    }
    public static void mergeSortChild(int[] array,int left,int right) {
        //判断结束
        if (left >= right) {
            return;
        }
        int mid = (right + left) / 2;

        mergeSortChild(array,left,mid);
        mergeSortChild(array,mid + 1,right);
        //合并数组
        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = right;

        int[] tmp = new int[right - left + 1];
        int k = 0;
        while (s1 <= e1 && s2 <= e2) {
            if (array[s1] < array[s2]) {
                tmp[k++] = array[s1++];
            }else {
                tmp[k++] = array[s2++];
            }
        }
        while (s1 <= e1) {
            tmp[k++] = array[s1++];
        }
        while (s2 <= e2){
            tmp[k++] = array[s2++];
        }
        //赋值给数组
        for (int i = 0; i < tmp.length; i++) {
            //i+left 使得右树tmp数组的数值也能正确对应原数组的下标
            array[i + left] = tmp[i];
        }
    }
}
