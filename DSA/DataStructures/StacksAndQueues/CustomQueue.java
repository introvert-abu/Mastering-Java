package DSA.DataStructures.StacksAndQueues;

public class CustomQueue {

    private int[] data;
    private static final int DEFAULT_SIZE = 5;
    private int end = 0;

    CustomQueue() {
        this(DEFAULT_SIZE);
    }

    CustomQueue(int size) {
        this.data = new int[size];
    }

    public void insert(int num) {
        if (isFull()) {
            int[] temp = new int[this.data.length * 2];
            for (int i = 0; i < this.data.length; i++) {
                temp[i] = this.data[i];
            }
            this.data = temp;
        }

        data[this.end++] = num;
    }

    public int remove() throws CustomStackException {
        if (isEmpty()) {
            throw new CustomStackException("Queue is Empty");
        }
        int val = this.data[0];

        for (int i = 1; i < this.end; i++) {
            this.data[i - 1] = this.data[i];
        }
        this.end--;

        return val;
    }

    public int front() throws CustomStackException {
        if (isEmpty()) {
            throw new CustomStackException("Queue is Empty");
        }

        return this.data[0];
    }

    private boolean isFull() {
        return this.end == this.data.length;
    }

    private boolean isEmpty() {
        return end == 0;
    }

    @Override
    public String toString() {
        String s = "";
        s += "[";
        for (int i = 0; i < end; i++) {
            if (i == end - 1) {
                s += this.data[i];
            } else {
                s += this.data[i] + ", ";
            }
        }
        s += "]";
        return s;
    }
}
