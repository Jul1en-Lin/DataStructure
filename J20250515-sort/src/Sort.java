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
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            //(j == -1)
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
        while (gap > 1) {
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
     */
    public static void heapSort(int[] array) {
        int end = array.length;
        while (end > 0){
            swap(array,0,end);
            siftDown(array,0,end);
            end--;
        }
    }

    private static void siftDown(int[] array, int parent,int length) {
        int child = 2*parent + 1;
        while (child < length) {
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
}
