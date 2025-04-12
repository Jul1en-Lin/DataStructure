import java.util.Arrays;

public class MyArrayList implements IList{
    private int[] elem;

    public MyArrayList() {
    }

    //记录数组中有效的数据个数
    private int usedSize;

    public MyArrayList(int[] elem) {
        this.elem = new int[Constants.DEFAULT_CAPACITY];
    }

    public int getUsedSize() {
        return this.usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    @Override
    public void add(int data) {
        //1.判断是否满了
        if(isFull()){
            grow();
        }
        //2.放数据
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }

    //扩容操作
    private void grow() {
        this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
    }

    private boolean isFull() {
        /*if(elem.length == usedSize){
            return true;
        }
        return false;*/
        return this.elem.length == this.usedSize;
    }

    @Override
    public void add(int pos, int data) throws PosCheckException {
        //1.判断是否满了
        if(isFull()){
            grow();
        }
        //2.检查下标是否合法
        checkPos(pos);
        //3.检查下标位置是否和usedSize一致，一致则不需要移动
        if (pos == usedSize) {
            this.elem[this.usedSize] = data;
            this.usedSize++;
            return;
        }
        //4.否则需要移动
        for (int i = this.usedSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];// 需要往后挪一个位置 故是i+1
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    private void checkPos(int pos) {
        if (pos < 0 || pos > this.usedSize) {
            throw new PosCheckException(Constants.ADD_POS_ILLEGALITY);
        }
    }

    @Override
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize - 1; i++) {
            if (toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize - 1; i++) {
            if (toFind == this.elem[i]) {
               return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int pos) throws EmptyListException {
        //注意数组是否为空
        if (isEmpty()){
            throw new EmptyListException(Constants.GET_POS_ILLEGALITY);
        }
        //检查pos合法性
        checkPos1(pos);
        return this.elem[pos];
    }

    private boolean isEmpty() {
        /*if (usedSize == 0) {
            return true;
        }
        return false;*/
        return this.usedSize == 0;
    }

    @Override
    public void set(int pos, int value) {
        //判断数组是否为空
        if (isEmpty()){
            throw new EmptyListException(Constants.EMPTY_LIST);
        }
        //判断pos的位置是否合法
        checkPos1(pos);

        this.elem[pos] = value;
    }
    private void checkPos1(int pos) {
        if (pos < 0 || pos >= this.usedSize) {
            throw new PosCheckException(Constants.SET_POS_ILLEGALITY);
        }
    }

    @Override
    public void remove(int toRemove) {
        //判断数组是否为空
        if (isEmpty()) {
            throw new EmptyListException(Constants.EMPTY_LIST);
        }
        int index = this.indexOf(toRemove);
        if (index == -1) {
            System.out.println("没有你想删除的数据");
        }
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
        //elem[usedSize] = null;

    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.usedSize; i++) {
            //elem[i] = null;
            elem[i] = 0;
        }

        this.usedSize = 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println(" ");
    }
}
