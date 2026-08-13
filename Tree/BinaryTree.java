package Tree;

public class BinaryTree {

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
            if(value < currNode.value) {
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

    public void traverse(Node node) {
        if(node == null) return;
        System.out.println(node.value);
        traverse(node.left);
        traverse(node.right);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertNode(3);
        binaryTree.insertNode(5);
        binaryTree.insertNode(2);
        binaryTree.insertNode(10);
        binaryTree.insertNode(14);
        binaryTree.insertNode(9);
        binaryTree.traverse(binaryTree.root);
    }
}
