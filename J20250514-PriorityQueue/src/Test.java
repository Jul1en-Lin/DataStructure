import java.util.Arrays;

public class Test {
    public static void main1(String[] args) {
        int[] arr = {1,2,3};
    }
    public static void main(String[] args) {
        int[] array = {13,5,42,13,65,4,10,34};
        Heap heap = new Heap();
        int[] ints = heap.smallestK(array, 3);
        System.out.println(Arrays.toString(ints));
    }
}
