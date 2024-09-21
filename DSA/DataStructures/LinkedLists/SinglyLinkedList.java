package DSA.DataStructures.LinkedLists;

// Data Container
public class SinglyLinkedList {

    // Data
    private class Node {
        private int val;
        private Node next;

        // COnstructor
        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // Instance Variables (means variables are object's)
    private Node head;
    private Node tail;
    private int size;

    // Constructor
    public SinglyLinkedList() {
        this.size = 0;
    }

    // setters
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        this.head = node;

        if (tail == null) {
            this.tail = node;
        }

        this.size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        this.size++;
    }

    public void insert(int index, int val) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node prev = this.get(index-1);
        Node node = new Node(val, prev.next);
        prev.next = node;

        this.size++;
    }

    public int removeFirst() {
        if (this.size <= 1) {
            this.tail = null;
        }

        int val = this.head.val;
        this.head = this.head.next;
        this.size--;

        return val;
    }

    public int removeLast() {
        if (this.size <= 1) {
            return removeFirst();
        }

        Node secondLast = this.get(size - 2);
        int val = secondLast.next.val;
        tail = secondLast;
        secondLast.next = null;
        this.size--;

        return val;
    }

    public int remove(int index) {
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }

        Node temp = this.get(index - 1);
        int val = temp.next.val;
        temp.next = temp.next.next;
        this.size--;

        return val;
    }

    // Getters
    public int getHead() {
        return this.head.val;
    }

    public int getTail() {
        return this.tail.val;
    }


    public int size() {
        return this.size;
    }

    public int getIndex(int val) {
        Node temp = this.head;
        int index = 0;
        while (temp.val != val) {
            temp = temp.next;
            index++;
        }

        return index;
    }

    private Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public int getNode(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.val;
    }

    public void display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
