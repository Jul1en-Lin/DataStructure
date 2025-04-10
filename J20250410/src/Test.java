public class Test {
    public void rotate(int[] nums, int k) {
    int ret = 0;
    for (int i =0; i < k; i++) {
        ret = nums[nums.length-1];
        nums[i+1] = nums[i];
        nums[i] = ret;
    }
}
    public static void main(String[] args) {

    }
}
