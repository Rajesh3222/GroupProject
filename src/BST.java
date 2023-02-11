import java.util.*;

class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BST {
    Node root;

    public BST() {
        this.root = null;
    }

    public void inorderTraversal(Node node, List<Node> nodes) {
        if (node == null) return;
        inorderTraversal(node.left, nodes);
        nodes.add(node);
        inorderTraversal(node.right, nodes);
    }

    public void convertToRightSkewedTree() {
        List<Node> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);
        root = null;
        for (Node node : nodes) {
            node.left = null;
            node.right = root;
            root = node;
        }
    }

    public void inorderPrint(Node node) {
        if (node == null) return;
        inorderPrint(node.right);
        System.out.print(node.value + " ");
        inorderPrint(node.left);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.root = new Node(50);
        bst.root.left = new Node(30);
        bst.root.right = new Node(60);
        bst.root.left.left = new Node(10);
        bst.root.right.left = new Node(55);
        bst.convertToRightSkewedTree();
        bst.inorderPrint(bst.root);
    }
}

