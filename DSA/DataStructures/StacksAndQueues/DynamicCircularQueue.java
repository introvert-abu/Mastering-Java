package DSA.DataStructures.StacksAndQueues;

public class DynamicCircularQueue extends CircularQueue {

    private static final int DEFAULT_SIZE = 5;

    DynamicCircularQueue() {
        super(DEFAULT_SIZE);
    }

    DynamicCircularQueue(int size) {
        super(size);
    }

    @Override
    public void insert(int num) {
        if (isFull()) {
            int[] temp = new int[this.data.length * 2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = this.data[(start + i) % data.length];
            }
            this.start = 0;
            this.end = this.data.length;
            this.data = temp;
            return;
        }

        super.insert(num);   
    }

    private boolean isFull() {
        return this.size == this.data.length;
    }
}