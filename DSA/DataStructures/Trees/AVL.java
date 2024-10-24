package DSA.DataStructures.Trees;

public class AVL {

    // Inner class representing a node in the AVL tree
    private class Node {
        private int val;       // Value of the node
        private int height;    // Height of the node
        private Node left;     // Left child
        private Node right;    // Right child

        // Constructor for creating a new node
        Node(int val) {
            this.val = val;
        }

        // Getter method for the node value
        private int getValue() {
            return val;
        }
    }

    private Node root; // Root node of the AVL tree

    // Constructor for initializing the AVL tree
    AVL() {
    }

    // Returns the height of the AVL tree
    public int height() {
        return root == null ? -1 : root.height; // Return -1 if tree is empty
    }

    // Returns the height of a given node
    private int height(Node node) {
        return node == null ? -1 : node.height; // Return -1 if node is null
    }

    // Checks if the AVL tree is balanced
    public boolean isBalanced() {
        return isBalanced(root);
    }

    // Helper method to check if a subtree is balanced
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true; // An empty tree is balanced
        }

        // Check balance condition for the current node and recurse for its children
        return Math.abs(height(node.left) - height(node.right)) <= 1
                ? isBalanced(node.left) && isBalanced(node.right)
                : false; // Not balanced
    }

    // Public method to insert a value into the AVL tree
    public void insert(int val) {
        root = insert(val, root); // Update root after insertion
    }

    // Recursive method to insert a value into the AVL tree
    private Node insert(int val, Node node) {
        if (node == null) {
            node = new Node(val); // Create a new node if current node is null
            return node;
        }

        // Traverse left or right based on the value to insert
        if (val < node.getValue()) {
            node.left = insert(val, node.left);
        } else {
            node.right = insert(val, node.right);
        }

        // Update the height of the current node
        updateHeight(node);

        // Rebalance the tree and return the new root
        return rotate(node);
    }

    // Rotates the node to maintain AVL properties
    private Node rotate(Node node) {
        int balance = height(node.left) - height(node.right); // Calculate balance factor

        // Left heavy case
        if (balance > 1) {
            // Left-Left case
            if (height(node.left.left) >= height(node.left.right)) {
                return rightRotate(node);
            } else { // Left-Right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // Right heavy case
        if (balance < -1) {
            // Right-Right case
            if (height(node.right.right) >= height(node.right.left)) {
                return leftRotate(node);
            } else { // Right-Left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node; // Return unchanged node if already balanced
    }

    // Performs a right rotation around the node
    private Node rightRotate(Node p) {
        Node c = p.left; // Store left child
        p.left = c.right; // Move right child of left to be left child of current
        c.right = p; // Perform rotation

        // Update heights of the involved nodes
        updateHeight(p);
        updateHeight(c);

        return c; // Return new root of this subtree
    }

    // Performs a left rotation around the node
    private Node leftRotate(Node p) {
        Node c = p.right; // Store right child
        p.right = c.left; // Move left child of right to be right child of current
        c.left = p; // Perform rotation

        // Update heights of the involved nodes
        updateHeight(p);
        updateHeight(c);

        return c; // Return new root of this subtree
    }

    // Pre-order traversal (root, left, right)
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    // Helper method for pre-order traversal
    private void preOrder(Node node) {
        if (node == null) {
            return; // Base case
        }

        System.out.print(node.val + " "); // Print current node's value
        preOrder(node.left); // Recur on left child
        preOrder(node.right); // Recur on right child
    }

    // In-order traversal (left, root, right)
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    // Helper method for in-order traversal
    private void inOrder(Node node) {
        if (node == null) {
            return; // Base case
        }

        inOrder(node.left); // Recur on left child
        System.out.print(node.val + " "); // Print current node's value
        inOrder(node.right); // Recur on right child
    }

    // Post-order traversal (left, right, root)
    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    // Helper method for post-order traversal
    private void postOrder(Node node) {
        if (node == null) {
            return; // Base case
        }

        postOrder(node.left); // Recur on left child
        postOrder(node.right); // Recur on right child
        System.out.print(node.val + " "); // Print current node's value
    }

    // Updates the height of a node based on its children
    private void updateHeight(Node node) {
        if (node != null) {
            node.height = Math.max(height(node.left), height(node.right)) + 1; // Update height
        }
    }

    // Searches for a value in the AVL tree
    public boolean search(int val) {
        return search(val, root); // Start search from the root
    }

    // Helper method for searching a value in the AVL tree
    private boolean search(int val, Node node) {
        if (node == null) {
            return false; // Base case: value not found
        }
        if (val == node.getValue()) {
            return true; // Value found
        }
        // Recur left or right based on the value
        return val < node.getValue() ? search(val, node.left) : search(val, node.right);
    }

    // Displays the AVL tree in a pretty format
    public void prettyDisplay() {
        display(root, 0);
    }

    // Helper method to display the tree visually
    private void display(Node node, int level) {
        if (node == null) {
            return; // Base case
        }

        display(node.right, level + 1); // Display right subtree

        // Print current node with indentation based on level
        if (level == 0) {
            System.out.println(node.getValue());
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t"); // Indentation for left siblings
            }
            System.out.println("|------>" + node.getValue()); // Display current node
        }

        display(node.left, level + 1); // Display left subtree
    }
}
