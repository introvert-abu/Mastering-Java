package DSA.DataStructures.Trees;

public class BST {

    BST() {
    }

    class Node {
        private int val;
        private int height;
        private Node left;
        private Node right;

        Node(int val) {
            this.val = val;
        }

        public int getValue() {
            return val;
        }
    }

    private Node root;

    private int height(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    public int height(int val) {
        Node temp = root;
        while (temp != null && temp.val != val) {
            if (val <= temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if (temp == null) {
            return -1;
        }

        return temp.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            insert(val, root);
        }
    }

    private void insert(int val, Node node) {
        if (val <= node.getValue()) {
            if (node.left == null) {
                node.left = new Node(val);
            } else {
                insert(val, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(val);
            } else {
                insert(val, node.right);
            }
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public void display() {
        display(root, "Root Node : ");
    }

    private void display(Node node, String detail) {
        if (node == null) {
            return;
        }

        System.out.println(detail + node.getValue());

        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + " : ");
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
            System.out.println(node.getValue());
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|------>"+ node.getValue());
        }

        display(node.left, level + 1);
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
}
