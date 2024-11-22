package OOP;

public class CustomGenArrayList<T extends Number> {
    private final int DEFAULT_SIZE = 0;
    private Object[] arr;
    private int size = 0;

    public CustomGenArrayList() {
        this.arr = new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if (this.isFull()) {
            this.resize();
        }
        this.arr[size++] = num;
    }

    private boolean isFull() {
        return this.arr.length == size;
    }

    private void resize() {
        Object[] temp = new Object[this.arr.length + 1];
        for (int i = 0; i < this.arr.length; i++) {
            temp[i] = this.arr[i];
        }
        this.arr = temp;
    }

    public void remove(int index) {
        Object[] temp = new Object[this.arr.length - 1];
        for (int i = 0; i < this.arr.length; i++) {
            if(i < index) {
                temp[i] = this.arr[i];
            }
            if (i > index) {
                temp[i-1] = this.arr[i];
            }
        }
        this.arr = temp;
        size--;
    }

    public void update(int index, T num) {
        this.arr[index] = num;
    }

    @Override
    public String toString (){
        String s = "";
        for (int i = 0; i < this.arr.length; i++) {
            if (i == 0) {
                s += "[";
            }
            s += this.arr[i];
            if (i != this.arr.length - 1) {
                s += ", ";
            }
            if (i == this.arr.length - 1) {
                s += "]";
            }
        }
        return s;
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)(this.arr[index]);
    }
}
