package Tree;

import java.util.ArrayDeque;

public class BinarySearchTree {

    private Node root;
    private int size;

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
            size = 1;
            return;
        }
        Node currNode = root;
        while(true) {
            if(value <= currNode.value) {
                if(currNode.left == null) {
                    currNode.left = newNode;
                    size++;
                    return;
                }
                currNode = currNode.left;
            }
            else {
                if(currNode.right == null) {
                    currNode.right = newNode;
                    size++;
                    return;
                }
                currNode = currNode.right;
            }
        }
    }

    public void preorderTraverse(Node node) {
        if(node == null) return;
        System.out.println("Preorder: " + node.value);
        preorderTraverse(node.left);
        preorderTraverse(node.right);
    }

    public void inorderTraverse(Node root) {
        if(root == null) return;
        inorderTraverse(root.left);
        System.out.println("Inorder/Ascending: " + root.value);
        inorderTraverse(root.right);
    }

    public void postorderTraverse(Node root) {
        if(root == null) return;
        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.println("Postorder: " + root.value);
    }

    public void levelOrder(Node node) {
        if(node == null) return;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        levelOrderPrivate(queue);
    }

    private void levelOrderPrivate(ArrayDeque<Node> queue) {
        // Done by own
        if(queue.isEmpty()) return;
        Node poll = queue.poll();
        System.out.println(poll.value);
        if(poll.left != null) queue.offer(poll.left);
        if(poll.right != null) queue.offer(poll.right);
        levelOrderPrivate(queue);
    }

    public void ascendingOrder(Node node) {
        inorderTraverse(node);
    }

    public void descendingOrder(Node node) {
        if(node == null) return;
        descendingOrder(node.right);
        System.out.println("Descending :" + node.value);
        descendingOrder(node.left);
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

    public Node[] findChildren(Node root, int value) {
        if(root == null) return null;
        if(root.value < value) return findChildren(root.right, value);
        else if(root.value > value) return findChildren(root.left, value);
        else {
            Node[] nodeArr = new Node[2];
            nodeArr[0] = root.left;
            nodeArr[1] = root.right;
            return nodeArr;
        }
    }

    public Node findSibling(Node root, int value) {
        Node parent = findImmediateParentNode(root, value);
        // value == root, parent is null
        if(parent == null) return null;
        if(parent.left != null && parent.left.value == value) return parent.right;
        return parent.left;
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

    public Node inorderSuccessor(Node root, int value) {
        Node successor = null;
        if(root == null) return root;
        while(root.value != value) {
            if (root.value > value) {
                successor = root;
                root = root.left;
            } else if(root.value < value) root = root.right;
            if(root == null) return null;
        }
        if(root.right != null) successor = findSmallestNode(root.right);
        return successor;
    }

    public Node inorderPredecessor(Node root, int value) {
        Node predecessor = null;
        if(root == null) return root;
        while(root.value != value) {
            if (root.value < value) {
                predecessor = root;
                root = root.right;
            } else if(root.value > value) root = root.left;
            if(root == null) return null;
        }
        if(root.left != null) predecessor = findLargestNode(root.left);
        return predecessor;
    }

    // My Approach. After learning the theoretical concept.
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

        Node res = node.right == null ? inorderPredecessor(node, node.value) : inorderSuccessor(node, node.value);

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

    public boolean contains(int value) {
        Node node = findNode(root, value);
        return node == null ? false : true;
    }

    public boolean validateBST(Node root) {
        return privateValidateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean privateValidateBST(Node root, long min, long max) {
        if (root == null) return true;
        if(root.value <= min || max < root.value) return false;
        return privateValidateBST(root.left, min, root.value) && privateValidateBST(root.right, root.value, max);
    }

    public Node lowestCommonAncestor(Node root, int val1, int val2) {
        if((root.value == val1) || (root.value == val2))
            return root;
        if(val1 == val2)
            return findNode(root, val1);
        if(!(contains(val1) && contains(val2)))
            throw new IllegalArgumentException("At least either of the nodes values are not present in the BST.");
        Node commonAncestor = root;
        while(commonAncestor.left != null && commonAncestor.right != null) {
            if (val1 <= commonAncestor.value && val2 <= commonAncestor.value) {
                commonAncestor = commonAncestor.left;
            } else if (val1 > commonAncestor.value && val2 >= commonAncestor.value) {
                commonAncestor = commonAncestor.right;
            } else {
                break;
            }
        }
        return commonAncestor;
    }

    public int calculateBSTSize(Node root) {
        if(root == null) return 0;
        return 1 + calculateBSTSize(root.left) + calculateBSTSize(root.right);
    }

    public int getSize() {
        return size;
    }

    int calcIntLog(int value) {
        int count = 0;
        while(value != 0) {
            value = value/2;
            count++;
        }
        return count;
    }
    public int minimumLevelsForCompleteTree(Node root) {
        // Works only for a complete tree, returns the number of levels.
        int size = calculateBSTSize(root);
        return calcIntLog(size);
    }
    public int heightBST(Node node) {
        // height is the number of edges at the longest part in the BST
        // levels = height + 1
        // height = level - 1
        if(node == null) return -1;
        return 1 + Math.max(heightBST(node.left), heightBST(node.right));
    }
    private int count;
    public Node KthSmallestElement(Node root, int count) {
        if(count > size || count < 1) {
            throw new IllegalArgumentException("Count value can't be greater than or less than size of BST.");
        }
        this.count = count;
        return privateKthSmallestElement(root);
    }
    private Node privateKthSmallestElement(Node root) {
        if(root == null) return null;
        Node res = privateKthSmallestElement(root.left);
        if(count == 1) {
            count = -1;
            return root;
        }
        else if(count == -1) return res;
        count--;
        res = privateKthSmallestElement(root.right);
        return res;
    }

    public Node KthLargestElement(Node root, int count) {
        if(count > size || count < 1) {
            throw new IllegalArgumentException("Count value can't be greater than or less than size of BST.");
        }
        this.count = count;
        return privateKthLargestElement(root);
    }
    private Node privateKthLargestElement(Node root) {
        if(root == null) return null;
        Node res = privateKthLargestElement(root.right);
        if(count == 1) {
            count = -1;
            return root;
        }
        else if(count == -1) return res;
        count--;
        res = privateKthLargestElement(root.left);
        return res;
    }

    public void deleteNodeBST(int value) {
        root = deleteNode(root, value);
    }

    // Optimized after learning from GFG
    private Node deleteNode(Node root, int value) {
        if(root == null) return root;
        if(root.value > value) root.left = deleteNode(root.left, value);
        else if(root.value < value) root.right = deleteNode(root.right, value);
        else { // root.value == value , the node to delete is found.

            // leaf node or node with one child
            if(root.right == null) {
                size--;
                return root.left;
            }
            if(root.left == null) {
                size--;
                return root.right;
            }
            // node to delete has 2 children
            Node successor = getSuccessor(root.right);
            root.value = successor.value;
            root.right = deleteNode(root.right, successor.value);
        }
        return root;
    }

    private Node getSuccessor(Node node) {
        if(node == null) return node;
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }



    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.insertNode(3);
        binaryTree.insertNode(5);
        binaryTree.insertNode(2);
        binaryTree.insertNode(10);
        binaryTree.insertNode(1);
        binaryTree.insertNode(4);
        binaryTree.insertNode(8);
        binaryTree.insertNode(7);
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
        System.out.println(binaryTree.inorderSuccessor(binaryTree.root, binaryTree.root.value).value);
        System.out.println(binaryTree.inorderSuccessor(binaryTree.findNode(binaryTree.root, 5), 10).value);
//        binaryTree.deleteNode(5);
        System.out.println(binaryTree.contains(5));
        binaryTree.inorderTraverse(binaryTree.root);
        binaryTree.preorderTraverse(binaryTree.root);
        binaryTree.postorderTraverse(binaryTree.root);
        binaryTree.ascendingOrder(binaryTree.root);
        binaryTree.descendingOrder(binaryTree.root);
        binaryTree.levelOrder(binaryTree.root);
        ;

        binaryTree.deleteNodeBST(5);
        System.out.println("After deletion of the node.....");
        binaryTree.preorderTraverse(binaryTree.root);
        boolean a = binaryTree.contains(5);
        System.out.println(a);
        binaryTree.levelOrder(binaryTree.root);

        int[] arr = {10, 8, 14, 3};
        for (int i = 0; i < arr.length; i++) {
            Node[] nodeArr = binaryTree.findChildren(binaryTree.root, arr[i]);
            System.out.print("The children of " + arr[i] + ": ");
            System.out.print(nodeArr[0] != null ? nodeArr[0].value : nodeArr[0]);
            System.out.print(" and ");
            System.out.println(nodeArr[1] != null ? nodeArr[1].value : nodeArr[1]);
        }
        System.out.println(binaryTree.calculateBSTSize(binaryTree.root));
        System.out.println(binaryTree.findSibling(binaryTree.root, 10).value);
        System.out.println(binaryTree.inorderSuccessor(binaryTree.root, 4).value);
        binaryTree.deleteNodeBST(3);
//        System.out.println(binaryTree.inorderSuccessor(binaryTree.root, 3).value);
        binaryTree.deleteNodeBST(9);
        binaryTree.insertNode(6);
        System.out.println(binaryTree.inorderPredecessor(binaryTree.root, 7).value);
        System.out.println(binaryTree.inorderSuccessor(binaryTree.root, 7).value);
        System.out.println(binaryTree.calculateBSTSize(binaryTree.root));
//        System.out.println(binaryTree.minimumLevelsForCompleteTree(binaryTree.root));
        System.out.println(binaryTree.heightBST(binaryTree.root));
        System.out.println(binaryTree.validateBST(binaryTree.root));
        try {
            System.out.println(binaryTree.lowestCommonAncestor(binaryTree.root, 6, 10).value);
            System.out.println("Size: " + binaryTree.getSize());
            System.out.println(binaryTree.KthSmallestElement(binaryTree.root, 5).value);
            System.out.println(binaryTree.KthLargestElement(binaryTree.root, 3).value);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Argument");
            System.out.println(e);
        }
    }
}
