package DSA.DataStructures.Heaps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Heaps<Integer> heap = new Heaps<>();
            heap.insert(100);
            heap.insert(10);
            heap.insert(20);
            heap.insert(50);
            heap.insert(75);
            System.out.println(heap.get());
            System.out.println(heap.remove());
            System.out.println(heap.get());
            ArrayList<Integer> list = heap.heapSort();
            System.out.println(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
