package demo1;

import java.util.Arrays;
import java.util.Scanner;


class MyClass {
    long var;

    public MyClass() {
    }

    public void MyClass(long param) { var = param; }//(1)
    public static void main(String[] args) {
        MyClass a, b;
        a =new MyClass();//(2)
        //b =new MyClass(5);//(3)
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[i--] = nums1[m - 1];
                m--;
            } else {
                nums1[i--] = nums2[n - 1];
                n--;
            }
        }
    }
}
class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < m; i++) {
            if (nums1[i] != 0) {
                nums1[i] = nums1[i];
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums2[j] != 0) {
                nums1[m+j] = nums2[j];
            }
        }
        Arrays.sort(nums1);
        for (int i = 0; i < m+n; i++) {
            System.out.print(nums1[i]);
        }
    }

}
public class Test {
    //大小写转换
    public static void main3(String[] args) {
        String str1="hello";
        String str2="he"+ new String("llo");
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
    }
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main2(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeElement(nums,1);
    }
    public static void fun1(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length-1;
        while (n > 0) {
            if (m > 0 && nums1[m-1] > nums2[n-1]) {
                nums1[i] = nums1[m-1];
                i--;
                m--;
            }else{
                nums1[i] = nums2[n-1];
                i--;
                n--;
            }
        }
    }

    public static void main1(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        /*Solution solution = new Solution();
        solution.merge(nums1,3,nums2,3);*/
        fun1(nums1,3,nums2,3);
    }


}
