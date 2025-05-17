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
    }


    public static void main1(String[] args) {
        int[] arr = new int[1_000];
        art.RandomOrder(arr);
        SortTest.bubbleSortTest(arr);
        SortTest.heapSortTest(arr);
        SortTest.shellSortTest(arr);
        SortTest.insertSortTest(arr);
    }
    public static void main(String[] args) {
        int[] arr = {10,5,3,73,25,26,142,46};
        Sort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    class solution{
        //挖孔法
        public static int parttion(int[] array,int low,int high) {
            int tmp = array[low];
            while (high > low) {
                while (array[high] >= tmp) {
                    high--;
                }
                array[low] = array[high];

                while (low < high) {
                    if (array[low] <= tmp) {
                        low++;
                    }
                    array[high] = array[low];
                }
            }

            array[low] = tmp;
            return low;
        }

        public static void quickSortNor(int[] array) {
            int start = 0;
            int end = array.length-1;
            int par = parttion(array,start,end);

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
                par = parttion(array,start,end);
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
    }
}
