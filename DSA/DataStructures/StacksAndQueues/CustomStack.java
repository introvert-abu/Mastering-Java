package DSA.DataStructures.StacksAndQueues;

public class CustomStack {

    private int[] data;
    private static final int DEFAULT_SIZE = 5;
    private int ptr = 0;

    CustomStack() {
        this(DEFAULT_SIZE);
    }

    CustomStack(int size) {
        this.data = new int[size];
    }

    public void push(int num) {
        if (isFull()) {
            int[] temp = new int[this.data.length * 2];
            for (int i = 0; i < this.data.length; i++) {
                temp[i] = this.data[i];
            }
            this.data = temp;
        }

        data[ptr++] = num;
    }

    private boolean isFull() {
        return this.ptr == this.data.length;
    }

    public int pop() throws CustomStackException{
        if (isEmpty()) {
            throw new CustomStackException("Stack is empty!");
        }
        
        return this.data[ptr--];
    }

    public int peek() throws CustomStackException{
        if (isEmpty()) {
            throw new CustomStackException("Stack is empty!");
        }

        return this.data[ptr];
    }

    private boolean isEmpty() {
        return ptr == 0;
    }

    @Override
    public String toString() {
        String s = "";
        s += "[";
        for (int i = 0; i <= ptr; i++) {
            if (i == ptr) {
                s += this.data[i];
            } else {
                s += this.data[i] + ", ";
            }
        }
        s += "]";
        return s;
    }
}
