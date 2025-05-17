import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Test {
    public class art{
        public static void order(int[] array){
            for (int i = 0; i < array.length; i++) {
                array[i] = i;
            }
        }

        public static void notOrder(int[] array) {
            /*int j = 0;
            for (int i = array.length-1; i >= 0 ; i--) {
                array[j++] = i;
            }*/
            for (int i = 0; i < array.length; i++) {
                array[i] = array.length-i;
            }
        }
        public static void RandomOrder(int[] array) {
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(100);
            }
        }
    }
    public class SortTest{
        public static void insertSortTest(int[] array) {
            int[] arr = Arrays.copyOf(array,array.length);
            long startTimes = System.currentTimeMillis();
            Sort.insertSort(arr);
            long endTimes = System.currentTimeMillis();
            System.out.println("插入排序用时："+(endTimes - startTimes));
        }
        public static void shellSortTest(int[] array) {
            int[] arr = Arrays.copyOf(array,array.length);
            long startTimes = System.currentTimeMillis();
            Sort.shellSort(arr);
            long endTimes = System.currentTimeMillis();
            System.out.println("希尔排序用时："+(endTimes - startTimes));
        }
        public static void heapSortTest(int[] array) {
            int[] arr = Arrays.copyOf(array,array.length);
            long startTimes = System.currentTimeMillis();
            Sort.heapSort(arr);
            long endTimes = System.currentTimeMillis();
            System.out.println("堆排序用时："+(endTimes - startTimes));
        }
        public static void bubbleSortTest(int[] array) {
            int[] arr = Arrays.copyOf(array,array.length);
            long startTimes = System.currentTimeMillis();
            Sort.bubbleSort(arr);
            long endTimes = System.currentTimeMillis();
            System.out.println("冒泡排序用时："+(endTimes - startTimes));
        }

        public static void quickSortTest(int[] array) {
            int[] arr = Arrays.copyOf(array,array.length);
            long startTimes = System.currentTimeMillis();
            Sort.bubbleSort(arr);
            long endTimes = System.currentTimeMillis();
            System.out.println("快速排序用时："+(endTimes - startTimes));
        }
    }


    public static void main1(String[] args) {
        int[] arr = new int[1_0000];
        art.notOrder(arr);
        SortTest.bubbleSortTest(arr);
        SortTest.heapSortTest(arr);
        SortTest.shellSortTest(arr);
        SortTest.insertSortTest(arr);
        SortTest.quickSortTest(arr);
    }
    public static void main(String[] args) {
        int[] arr = {10,5,3,73,25,26,142,46};
        Sort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
