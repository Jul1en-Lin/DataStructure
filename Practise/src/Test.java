    import java.util.*;

public class Test {

    /*public static boolean containsNearbyDuplicate(int[] nums, int key) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        boolean flg = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    set.add(i);
                    set.add(j);
                    flg = true;
                    break;
                }
            }
        }
        if (!flg) {
            return false;
        } else {
            Object[] ret = set.toArray();
            int i = (int) ret[ret.length-1];
            int j = (int) ret[ret.length-2];
            if (Math.abs(i - j) <= key) {
                return true;
            } else {
                return false;
            }
        }
    }*/

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
    public static void main5(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(1,3);
        Set<Character> set = new HashSet<>();
        System.out.println(map.get(1));
        String str = "sef";
        str.toUpperCase();

    }
    public static void main2(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        //System.out.println(containsNearbyDuplicate(nums, 2));
    }
    public static void main1(String[] args) {
        String str = "adbs";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
        }
        Random random = new Random();
        random.nextInt();
    }

    public static void main(String[] args) {
        //System.out.println(containsNearbyDuplicate(nums, 2));
        System.out.println("练习1");
    }
}
