package DSA.DataStructures.Trees;

public class SegmentTree {

    // Inner class representing a node of the segment tree
    private static class Node {
        private int val;               // Value stored at the node (sum of the interval)
        private int leftInterval;      // Start of the interval this node represents
        private int rightInterval;     // End of the interval this node represents
        private Node left;             // Left child of the node
        private Node right;            // Right child of the node

        Node(int leftInterval, int rightInterval) {
            this.leftInterval = leftInterval;
            this.rightInterval = rightInterval;
        }
    }

    private Node root;  // Root of the segment tree

    // Constructor to build the segment tree from the input array
    SegmentTree(int[] nums) {
        // Edge case: Handle empty array input
        if (nums == null || nums.length == 0) {
            System.out.println("Array is empty. Segment Tree cannot be constructed.");
            return;
        }

        this.root = constructTree(nums, 0, nums.length - 1);
    }

    // Recursively constructs the segment tree
    private Node constructTree(int[] nums, int start, int end) {
        // Base case: Leaf node, where the interval covers a single element
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.val = nums[start];
            return leaf;
        }

        // Recursively build left and right subtrees
        Node node = new Node(start, end);
        int mid = start + ((end - start) >> 1);

        node.left = constructTree(nums, start, mid);
        node.right = constructTree(nums, mid + 1, end);

        // The current node value is the sum of its left and right child values
        node.val = node.left.val + node.right.val;
        return node;
    }

    // Displays the tree in linear form
    public void display() {
        if (root != null) {
            display(this.root);
        }
    }

    // Recursively display the tree in a linear form
    private void display(Node node) {
        String str = "";

        if (node.left != null) {
            str += "Interval [" + node.left.leftInterval + " - " + node.left.rightInterval + "] and data "
                    + node.left.val + " =>";
        } else {
            str += "No left child ";
        }

        str += " Interval [" + node.leftInterval + " - " + node.rightInterval + "] and data " + node.val + " <=";

        if (node.right != null) {
            str += " Interval [" + node.right.leftInterval + " - " + node.right.rightInterval + "] and data "
                    + node.right.val;
        } else {
            str += " No right child";
        }

        System.out.println(str);

        if (node.left != null) {
            display(node.left);
        }

        if (node.right != null) {
            display(node.right);
        }
    }

    // Displays the tree in a pretty hierarchical format
    public void prettyDisplay() {
        display(this.root, 0);
    }

    // Recursive method for pretty printing the tree with indentation
    private void display(Node node, int level) {
        if (node == null) {
            return;
        }

        display(node.right, level + 1);

        if (level == 0) {
            System.out.println(node.val + " [" + node.leftInterval + " - " + node.rightInterval + "]");
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println(
                    "|------> " + node.val + " [" + node.leftInterval + " - " + node.rightInterval + "]");
        }

        display(node.left, level + 1);
    }

    // Queries the sum of the range [qStart, qEnd]
    public int query(int qStart, int qEnd) {
        return query(this.root, qStart, qEnd);
    }

    // Recursive method to query the sum in the range [qStart, qEnd]
    private int query(Node node, int qStart, int qEnd) {
        // If the node's interval is completely within the query range
        if (node.leftInterval >= qStart && node.rightInterval <= qEnd) {
            return node.val;
        } 
        // If the node's interval is completely outside the query range
        else if (node.rightInterval < qStart || node.leftInterval > qEnd) {
            return 0;
        }

        // Partial overlap: query both left and right children
        return this.query(node.left, qStart, qEnd) + this.query(node.right, qStart, qEnd);
    }

    // Updates the value at a specific index and updates relevant tree nodes
    public void update(int index, int val) {
        this.root.val = update(this.root, index, val);
    }

    // Recursive method to update the value at a specific index
    private int update(Node node, int index, int val) {
        // Check if the index is within the current node's interval
        if (index <= node.rightInterval && index >= node.leftInterval) {
            // Base case: Leaf node, update its value
            if (index == node.leftInterval && index == node.rightInterval) {
                node.val = val;
                return val;
            } else {
                // Recursively update left and right children and adjust the current node value
                int leftVal = update(node.left, index, val);
                int rightVal = update(node.right, index, val);

                node.val = leftVal + rightVal;
                return node.val;
            }
        }

        return node.val;
    }
}
