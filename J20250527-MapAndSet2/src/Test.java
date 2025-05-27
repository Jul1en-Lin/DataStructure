import java.util.*;
class Student{
    public String id;

    public Student(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                '}';
    }
}
public class Test {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.push(12,999);
        hashBuck.push(2,999);
        System.out.println(hashBuck);
    }
    public static void main5(String[] args) {
        Set<String> set = new TreeSet<>();
        //set.add(null);
        set.add("Lin");
        //set.remove(null);
        System.out.println(set);
    }
    public static void main4(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put(null,12);
    }
    public static void main3(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("dfsd"));
        System.out.println(set.toString());
    }
    public static void main2(String[] args) {
        Set<String> set = new TreeSet<>();

        set.add("LinJulien");
        set.add("ishandsomeboy");
        //set.remove(null);//空指针异常
        System.out.println(set.contains("2"));
        //set.clear();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
    public static void main1(String[] args) {
        Map<Object,Integer> map = new TreeMap<>();
        map.put(123,999);
        map.put(23,999);
        map.put("sfsf",999);
        map.put("afsf",999);
        map.put("aasf",999);
        map.put(23,11);
        Set<Map.Entry<Object, Integer>> set = map.entrySet();
        for (Map.Entry<Object, Integer> entry: set) {
            System.out.println("key: "+entry.getKey()+" -> val: "+entry.getValue());
        }
        System.out.println(set);
    }
}
