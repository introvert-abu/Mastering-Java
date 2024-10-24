package DSA.DataStructures.Trees;

import java.util.Scanner;

public class BinaryTree {

    BinaryTree() {
    }

    class Node {
        private int val;
        private Node left;
        private Node right;

        Node() {
            this(0);
        }

        Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the value for root Node : ");
        int val = scanner.nextInt();
        this.root = new Node(val);
        populate(scanner, this.root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Want to add in the left of " + node.val);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter value for the left node of " + node.val);
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner, node.left);
        }

        System.out.println("Wanna add in the right of " + node.val);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter value for the right node of " + node.val);
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.val);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay() {
        display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }

        display(node.right, level + 1);
        if (level == 0) {
            System.out.println(node.val);
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|------->" + node.val);
        }

        display(node.left, level + 1);
    }
}