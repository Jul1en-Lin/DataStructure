import java.util.Scanner;

//旋转数组
class Solution {
    void rotate(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        rotate(nums, 0, nums.length-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length-1);
    }
}

class Solution1 {
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length-1];
            for (int j = nums.length-1; j >=1; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
    }
}
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6};
        solution.rotate(nums,2);

    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组1");
        String str1 = scanner.nextLine();
        System.out.println("输入数组2");
        String str2 = scanner.nextLine();
        StringBuilder stringBuilder = fun1(str1, str2);
        System.out.println(stringBuilder);
    }

    //删除部分字符
    private static StringBuilder fun1(String str1, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        int pos = 0;
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            boolean flg = true;
            char ch1 = str1.charAt(i);
            for (int j = 0; j < str2.length(); j++) {
                char ch2 = str2.charAt(j);
                if (ch1 == ch2) {
                    flg = false;
                    break;
                }
            }
            count++;
            char ret = str1.charAt(count-1);
            if (flg) {
                stringBuilder.append(ret);
                pos++;
            }
        }
        return stringBuilder;
    }
}
