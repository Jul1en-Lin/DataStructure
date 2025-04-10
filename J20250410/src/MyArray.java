public class MyArray <T>extends Student{
    public MyArray(int age) {
        super(age);
        this.array = array;
    }

    public Object[] array = new Object[10];

    public T getPos(int pos) {
        return (T)this.array[pos];
    }

    public void setArray(int pos, T val) {
        this.array[pos] = val.toString();
    }
}
