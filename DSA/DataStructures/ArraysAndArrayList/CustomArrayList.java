package DSA.DataStructures.ArraysAndArrayList;

public class CustomArrayList {
    private final int DEFAULT_SIZE = 0;
    private int[] arr;
    private int size = 0;

    public CustomArrayList() {
        this.arr = new int[DEFAULT_SIZE];
    }

    public void add(int num) {
        if (this.isFull()) {
            this.resize();
        }
        this.arr[size++] = num;
    }

    private boolean isFull() {
        return this.arr.length == size;
    }

    private void resize() {
        int[] temp = new int[this.arr.length * 2];
        for (int i = 0; i < this.arr.length; i++) {
            temp[i] = this.arr[i];
        }
        this.arr = temp;
    }

    public void remove(int index) {
        size--;
    }

    public void update(int index, int num) {
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

    public int get(int index) {
        return this.arr[index];
    }
}
