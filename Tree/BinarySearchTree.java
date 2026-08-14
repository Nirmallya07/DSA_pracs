package Tree;

public class BinarySearchTree {

    private Node root;

    private class Node {
        int value;
        Node left, right;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public void insertNode(int value) {
        Node newNode = new Node(value, null, null);
        if(root == null) {
            root = newNode;
            return;
        }
        Node currNode = root;
        while(true) {
            if(value <= currNode.value) {
                if(currNode.left == null) {
                    currNode.left = newNode;
                    return;
                }
                currNode = currNode.left;
            }
            else {
                if(currNode.right == null) {
                    currNode.right = newNode;
                    return;
                }
                currNode = currNode.right;
            }
        }
    }

    public void preorderTraverse(Node node) {
        if(node == null) return;
        System.out.println(node.value);
        preorderTraverse(node.left);
        preorderTraverse(node.right);
    }
    public Node findNode(Node node, int value) {
        if (node == null) return null;
        else if (node.value == value) return node;
        else if (node.value < value) return findNode(node.right, value);
        else return findNode(node.left, value);
    }

    public Node findImmediateParentNode(Node node, int value) {
        if (node == null) return null;
        if (node.value == value) return  null; // For working with root node.
        else if(node.right != null && node.right.value == value) return node;
        else if(node.left != null && node.left.value == value) return node;
        else if(node.value < value) return findImmediateParentNode(node.right, value);
        else return findImmediateParentNode(node.left, value);
    }

    public Node findSmallestNode(Node node) {
        if(node == null) return null;
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
    public Node findLargestNode(Node node) {
        if(node == null) return null;
        while(node.right != null) {
            node = node.right;
        }
        return node;
    }
    public Node inorderSuccessor(Node node) {
        if(node == null) return null;
        if (node.right == null) return null;
        node = node.right;
        return findSmallestNode(node);

    }
    public Node inorderPredecessor(Node node) {
        if(node == null) return null;
        if(node.left == null) return null;
        node = node.left;
        return findLargestNode(node);
    }
    public void deleteNode(int value) {

        Node node = findNode(root, value);
        if(node == null) {
            System.out.println("The node to delete is not found.");
            return;
        }

        // If the node to delete is a leaf node.
        if(node.left == null && node.right == null) {
            Node parent = findImmediateParentNode(root, node.value);
            if(parent == null) {
                root = null;
                return;
            }
            if(parent.right == node) parent.right = null;
            else parent.left = null;
            return;
        }

        Node res = node.right == null ? inorderPredecessor(node) : inorderSuccessor(node);

        Node parent = findImmediateParentNode(node, res.value);
        node.value = res.value;
        if(parent.right == res) {
            if(res.right != null) parent.right = res.right;
            else if(res.left != null) parent.right = res.left;
            else parent.right = null;
        }
        else {
            if(res.right != null) parent.left = res.right;
            else if(res.left != null) parent.left = res.left;
            else parent.left = null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.insertNode(3);
        binaryTree.insertNode(5);
        binaryTree.insertNode(2);
        binaryTree.insertNode(10);
        binaryTree.insertNode(14);
        binaryTree.insertNode(9);
        binaryTree.preorderTraverse(binaryTree.root);
        System.out.println("---------------------------------------");
        Node res = binaryTree.findNode(binaryTree.root, 10);
        System.out.println(res.value);
        System.out.println(res.left.value);
        System.out.println(res.right.value);
        System.out.println(binaryTree.findSmallestNode(binaryTree.root).value);
        System.out.println(binaryTree.findSmallestNode(binaryTree.findNode(binaryTree.root, 5)).value);
        System.out.println(binaryTree.findSmallestNode(binaryTree.findNode(binaryTree.root, 10)).value);
        System.out.println(binaryTree.inorderSuccessor(binaryTree.root).value);
        System.out.println(binaryTree.inorderSuccessor(binaryTree.findNode(binaryTree.root, 5)).value);
        binaryTree.deleteNode(5);
        System.out.println("After deletion of the node.....");
        binaryTree.preorderTraverse(binaryTree.root);
    }
}
