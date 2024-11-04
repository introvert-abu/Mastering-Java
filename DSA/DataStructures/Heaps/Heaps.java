package DSA.DataStructures.Heaps;

import java.util.List;
import java.util.ArrayList;

class Heaps<T extends Comparable<T>> {

    private List<T> minHeap;

    Heaps() {
        this.minHeap = new ArrayList<>();
    }

    private void swap(int first, int second) {
        T temp = minHeap.get(first);
        minHeap.set(first, minHeap.get(second));
        minHeap.set(second, temp);
    }

    private int parent(int index) {
        return (index -1 ) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void insert(T value) {
        minHeap.add(value);
        upHeap(minHeap.size() - 1);
    }

    private void upHeap(int index) {
        int parent = parent(index);
        if (minHeap.get(index).compareTo(minHeap.get(parent)) < 0) {
            swap(index, parent);
            upHeap(parent);
        }
    }

    public T remove() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Heap is Empty!...");
        }

        swap(0, minHeap.size()-1);

        T minimumValue = minHeap.remove(minHeap.size()-1);

        if (!this.isEmpty()) {
            downHeap(0);
        }

        return minimumValue;
    }

    private void downHeap(int index) {
        int min = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < minHeap.size() && minHeap.get(min).compareTo(minHeap.get(left)) > 0) {
            min = left;
        }

        if (right < minHeap.size() && minHeap.get(min).compareTo(minHeap.get(right)) > 0) {
            min = right;
        }

        if (min != index) {
            swap(index, min);
            downHeap(min);
        }
    }

    public List<T> heapSort() throws Exception {
        List<T> list = new ArrayList<>();
        while (!this.isEmpty()) {
            list.add(this.remove());
        }

        return list;
    }

    public T peek() throws Exception {
        if (minHeap.isEmpty()) {
            throw new Exception("Heap is Empty!...");
        }

        return minHeap.get(0);
    }

    public String toString() {
        String s = "";
        s += "[";
        for (T t : minHeap) {
            if (t == minHeap.get(minHeap.size()-1)) {
                s += t;
            } else {
                s += t + ", ";
            }
        }
        s += "]";

        return s;
    }

    public boolean isEmpty() {
        return minHeap.isEmpty();
    }
}