package DSA.DataStructures.LinkedLists;

public class DoublyLinkedList {

    private class Node {
        Node prev;
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node prev, int val) {
            this.prev = prev;
            this.val = val;
        }

        public Node(Node prev, int val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = this.head;
        if (head != null) {
            head.prev = node;
        }
        this.head = node;
        if (this.tail == null) {
            this.tail = node;
        }

        this.size++;
    }

    public void insertLast(int val) {
        if (size == 0 || head == null) {
            insertFirst(val);
            return;
        }

        Node prev = this.tail;
        Node node = new Node(prev, val);
        tail.next = node;
        this.tail = node;

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

        Node prev = this.getNode(index - 1);
        Node node = new Node(prev, val, prev.next);
        prev.next.prev = node;
        prev.next = node;

        this.size++;
    }

    public int removeFirst() {
        int val = this.head.val;
        this.head.next.prev = null;
        this.head = this.head.next;
        if (size <= 1) {
            this.tail = null;
        }

        this.size--;
        return val;
    }

    public int removeLast() {
        if (size <= 1) {
            return removeFirst();
        }

        Node secondLast = this.getNode(size - 2);
        int val = tail.val; 
        secondLast.next = null;
        tail.prev = null;
        tail = secondLast;
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

        Node prev = this.getNode(index - 1);
        int val = prev.next.val;
        prev.next = prev.next.next;
        prev.next.prev = prev;
        this.size--;

        return val;
    }

    public int size() {
        return size;
    }

    private Node getNode(int index) {
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void displayDsc() {
        Node temp = this.tail;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.prev;
        }
        System.out.println("Start");        
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
