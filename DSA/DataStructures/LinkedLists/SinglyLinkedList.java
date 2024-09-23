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

        Node prev = this.get(index - 1);
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

    // Inserting Using Recursion
    public void insertRec(int index, int val) {
        Node temp = this.head;
        insertRecHelper(index, val, temp);
    }

    private void insertRecHelper(int index, int val, Node node) {
        if (index == 0) {
            Node newNode = new Node(val);
            newNode.next = this.head;
            this.head = newNode;
            if (tail == null) {
                this.tail = head;
            }
            this.size++;
            return;
        } else if (index == 1) {
            Node newNode = new Node(val);
            newNode.next = node.next;
            node.next = newNode;
            this.tail = this.tail.next;
            this.size++;
            return;
        } else if (index == size) {
            Node newNode = new Node(val);
            this.tail.next = newNode;
            this.tail = newNode;
            this.size++;
            return;
        } 

        insertRecHelper(index - 1, val, node.next);
    }

    // Insert Using Recursion Using Kunal Kushwaha Method
    public void insertRecKunal(int index, int val) {
        this.head = insertRecKunal(index, val, head);
    }

    private Node insertRecKunal(int index, int val, Node node) {
        if (index == 0) {
            Node newNode = new Node(val);
            newNode.next = node;
            this.size++;

            return newNode;
        }
        node.next = insertRecKunal(index - 1, val, node.next);

        return node;
    }

    // Remove Duplicates
    public void removeDuplicates() {
        Node temp = this.head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
                this.size--;
            } else {
                temp = temp.next;
            }
        }
        this.tail = temp;
        this.tail.next = null;
    }

    // MergeLists
    public static SinglyLinkedList merge(SinglyLinkedList list1, SinglyLinkedList list2) {
        Node l = list1.head;
        Node r = list2.head;
        SinglyLinkedList mergedList = new SinglyLinkedList();
        while (l != null && r != null) {
            if (l.val < r.val) {
                mergedList.insertLast(l.val);
                l = l.next;
            } else {
                mergedList.insertLast(r.val);
                r = r.next;
            }
        }

        while (l != null) {
            mergedList.insertLast(l.val);
            l = l.next;
        }

        while (r != null) {
            mergedList.insertLast(r.val);
            r = r.next;
        }

        return mergedList;
    }

    // BubbleSort
    public void bubbleSort() {
        helper(this.size - 1, 0);
    }

    private void helper(int row, int col) {
        if (row == 0) {
            return;
        }

        if (row > col) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.val > second.val) {
                if (first == head) {
                    this.head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    this.tail = first;
                    prev.next = second;
                    second.next = first;
                    tail.next = null;
                } else {
                    Node prev = get(col - 1);
                    first.next = second.next;
                    prev.next = second;
                    second.next = first;
                }
            }
            helper(row, col + 1);
        } else {
            helper(row - 1, 0);
        }
    }

    // Recursion Reverse
    public void reverse() {
        rev(this.head);
    }

    private void rev(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        rev(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public void revHalf() {
        Node mid = findMid(this.head);
        Node fh = this.head;
        Node sh = reverse(mid.next);
        while (fh != null && sh != null) {
            Node temp = fh.next;
            fh.next = sh;
            fh = temp;
            temp = sh.next;
            sh.next = fh;
            sh = temp;
        }

        if (fh != null)
            fh.next = null;
    }

    private Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node next = curr;
        while (next != null) {
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private Node findMid(Node node) {
        if (node == null || node.next == null)
            return node;
        Node s = node;
        Node f = node;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        return s;
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
        System.out.println("Head : "+this.head.val);
        System.out.println("Tail : "+this.tail.val);
    }
}
