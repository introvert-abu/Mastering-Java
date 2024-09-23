package DSA.DataStructures.StacksAndQueues;

public class CircularQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 5;
    protected int start = 0;
    protected int end = 0;
    protected int size = 0;

    CircularQueue() {
        this(DEFAULT_SIZE);
    }

    CircularQueue(int size) {
        this.data = new int[size];
    }

    public void insert(int num) {
        data[this.end++] = num;
        end = end % data.length;
        this.size++;
    }

    public int remove() throws CustomStackException {
        if (isEmpty()) {
            throw new CustomStackException("Queue is Empty");
        }
        int val = this.data[start++];

        start = start % data.length;
        size--;
        return val;
    }

    public int front() throws CustomStackException {
        if (isEmpty()) {
            throw new CustomStackException("Queue is Empty");
        }

        return this.data[start];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String s = "";
        s += "[";
        int i = start;
        do {
            s += this.data[i] + ", ";
            i++;
            i = i % data.length;
        } while (i != end);
        s += "]";
        return s;
    }
}
