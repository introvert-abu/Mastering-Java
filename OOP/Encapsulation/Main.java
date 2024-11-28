class Node {
    private int val;
    private Node next;

    Node () {
        this.val = 0;
        this.next = null;
    }

    Node (int val) {
        this.val = val;
        this.next = null;
    }

    

    Node (int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [val=" + val + ", next=" + next + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Node[] nodes = new Node[5];
        for (int i = 0; i < 5; i++) {
            if (i != 0)
                nodes[i] = new Node(i, nodes[i-1]);
            else 
                nodes[i] = new Node(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(nodes[i]);
        }
    }
}