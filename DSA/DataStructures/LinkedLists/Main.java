package DSA.DataStructures.LinkedLists;

public class Main {
    public static void main(String[] args) {
        /* 
        // SLL
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertFirst(20);
        list.display();
        list.insertFirst(10);
        list.display();
        list.insertLast(30);
        list.display();
        list.insert(0, 0);
        list.display();
        list.insert(4, 21);
        list.display();
        System.out.println(list.remove(4));
        list.display();
        System.out.println("Size : "+list.size());
        System.out.println(list.getIndex(20));
        
        // DLL
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.insertFirst(2);
        ll.insertFirst(0);
        ll.insertLast(3);
        ll.insertLast(4);
        ll.insertLast(5);
        ll.insertLast(6);
        ll.insertLast(7);
        ll.insertLast(8);
        ll.insert(1, 1);
        ll.display();
        System.out.println("Size : "+ll.size());
        System.out.println("Removed "+ll.removeFirst());
        System.out.println("Removed "+ll.removeLast());
        ll.display();
        System.out.println("Removed "+ll.remove(3));
        ll.display();
        ll.displayDsc();
        System.out.println("Size : "+ll.size());

        // CLL
        CircularLL ll = new CircularLL();
        ll.insert(0);
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.delete(3);
        ll.display();        
        
        // Problems
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.insertRec(0, 0);
        ll.insertRec(1, 1);
        ll.insertRec(2, 2);
        ll.insertRec(3, 3);
        ll.display();
        ll.insertRecKunal(0, 0);
        ll.insertRecKunal(4, 3);
        ll.display();
        ll.display();
        ll.removeDuplicates();
        ll.display();
        */

        // SinglyLinkedList l1 = new SinglyLinkedList();
        // SinglyLinkedList l2 = new SinglyLinkedList();
        // l1.insertLast(0);
        // l1.insertLast(1);
        // l1.insertLast(2);
        // l2.insertLast(0);
        // l2.insertLast(1);
        // l2.insertLast(2);

        // SinglyLinkedList l3 = SinglyLinkedList.merge(l1, l2);
        // l3.display();

        SinglyLinkedList ll = new SinglyLinkedList();
        for (int i = 1; i <= 5; i++) {
            ll.insertLast(i);
        }
        ll.display();
        ll.revHalf();
        ll.display();
    }
}
