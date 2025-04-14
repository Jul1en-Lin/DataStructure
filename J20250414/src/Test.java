import java.util.ArrayList;
import java.util.List;

public class Test {
    //杨辉三角
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ret.add(list1);
        for (int i = 1; i < numRows; i++) {
            //1.布置首个的
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            //2.中间的
            List<Integer> preRow = ret.get(i-1);
            for (int j = 1 ; j < i; j++) {
                int tmp = preRow.get(j) + preRow.get(j-1);
                curRow.add(tmp);
            }
            //3.最后的
            curRow.add(1);

            ret.add(curRow);
        }
        return ret;
    }
    public static void main(String[] args) {
        List<List<Integer>> ret = generate(5);
        System.out.println(ret);
    }
}
