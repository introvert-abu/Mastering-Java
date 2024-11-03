package DSA.DataStructures.Heaps;

public class Main {
    public static void main(String[] args) {
        try {
            Heaps<Integer> heap = new Heaps<>();
            heap.insert(100);
            heap.insert(10);
            heap.insert(20);
            heap.insert(50);
            heap.insert(75);
            System.out.println(heap.remove());
            System.out.println(heap);
            System.out.println(heap.heapSort());
            System.out.println(heap);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
