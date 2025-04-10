import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MyArray<Student> myArray = new MyArray<>(1);
        myArray.setArray(1,new Student(4));
        System.out.println(myArray.getPos(1));
    }
    public static void main7(String[] args) {
        int a = 10;
        Integer i = Integer.valueOf(a);
    }
    public static void main6(String[] args) {
        /*MyArray<String> myArray = new MyArray<>();
        myArray.setArray(0,"sfsfs");
        String ret = myArray.getPos(0);
        System.out.println(ret);*/
    }
    public static void main5(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        char ch = input.charAt(0);
    }
    public static void main4(String[] args) {
       /* MyArray array = new MyArray();
        Object pos = array.getPos(1);
        System.out.println(pos);*/
    }
    public static void main3(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);//false
        //Integer range[-128,128);
        Integer c = 127;
        Integer d = 127;
        System.out.println(c == d);//true
        Integer e = -128;
        Integer f = -128;
        System.out.println(e == f);//true
        Integer g = -129;
        Integer h = -129;
        System.out.println(g == h);//false
    }
    public static void main2(String[] args) {
        int i = 10;
        //装箱
        Integer ii = Integer.valueOf(i);//手动装箱
        Integer ii2 = i;//自动装箱
        //Integer ij = new Integer(i);//outdated
        int iu = i;//自动拆箱
        int ii1 = (int) i;//手动拆箱
    }

    public static void main1(String[] args) {
        Integer i = 1;
        Character a = 'a';
        Byte b = 'a';
        byte b1 = b.byteValue();
        System.out.println(b1);
        Short aShort = 10;
        Long along = 1008l;
        System.out.println(along);
        Double adouble = 10.001;
        System.out.println(adouble);
        Boolean aboolean = true;
        System.out.println(!aboolean);
        Float afloat = 9.28f;
        System.out.println(afloat);
    }
}
