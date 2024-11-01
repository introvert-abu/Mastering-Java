package DSA.DataStructures.Heaps;

import java.util.ArrayList;

public class Heaps<T extends Comparable<T>> {

    private ArrayList<T> list;

    Heaps() {
        this.list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public void insert(T value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upheap(p);
        }
    }

    public T remove() throws Exception {
        if (list.size() == 0) {
            throw new Exception("Heap is Empty");
        }

        T removed = list.get(0);

        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downHeap(0);
        }

        return removed;
    }

    private void downHeap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(left).compareTo(list.get(min)) < 0) {
            min = left;
        }

        if (right < list.size() && list.get(right).compareTo(list.get(min)) < 0) {
            min = right;
        }

        if (min != index) {
            swap(index, min);
            downHeap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> sortedList = new ArrayList<>();

        while (!list.isEmpty()) {
            sortedList.add(this.remove());
        }

        return sortedList;
    }

    public T get() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Heap is Empty!");
        }

        return list.get(0);
    }
}
