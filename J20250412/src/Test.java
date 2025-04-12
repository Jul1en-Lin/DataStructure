class Food{

}

class Fruit extends Food{

}
class Apple extends Fruit{

}

class Banana extends Fruit{

}

class Student <T> extends Person {
    //上界

}
class Person{
    public static<T> T fun1() {
        return null;
    }
    //类里只有一个静态方法时可以这么写
}

class Animal<T> {

}

class dog <T extends Animal<T>>extends Animal<T> {

}
public class Test {
    public static void fun5(MyArray<? super Fruit> myArray){
        myArray.setData(new Apple());
        myArray.setData(new Banana());
        myArray.setData(new Fruit());
        //myArray.setData(new Food()); error
    }
    public static void fun4(MyArray<? extends Fruit> myArray){
        Fruit fr1 = myArray.getData();
        //Apple fr1 = myArray.getData(); error
    }
    public static void main(String[] args) {
        MyArray<Banana> m1 = new MyArray<>();
        Banana data = m1.getData();
        MyArray<Apple> m2 = new MyArray<>();
        Apple data1 = m2.getData();
    }
    public static void fun3(Student<?> student) {
        Student<Number> student1 = new Student<>();
    }

    public static void fun2(Animal<? super dog> tmp) {
        Animal<Animal> animalAnimal = new Animal<>();
        Animal<dog> animalAnimal2 = new Animal<>();
    }
    public static void main1(String[] args) {
        MyArray<Integer> myArray = new MyArray<>();
        //MyArray<String> myArray2 = new MyArray<>(); error
        Student<Person> student = new Student<>();
        Student<Student> student2 = new Student<>();
        Person.<String>fun1();
    }
}
