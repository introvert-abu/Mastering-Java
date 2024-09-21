package DSA.DataStructures.LinkedLists;

public class CircularLL {

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public CircularLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        node.next = this.head;
        this.tail = node;
    }

    public void delete(int val) {
        Node node = this.head;
        if (node == null) {
            return;
        }
        if (node.val == val) {
            this.head = this.head.next;
            this.tail.next = this.head;
            return;
        }
        do {
            Node n = node.next;
            if (n.val == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != this.head);
    }

    public void display() {
        Node temp = this.head;
        do {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        } while (this.head != temp);
        System.out.println("START");
    }
}
