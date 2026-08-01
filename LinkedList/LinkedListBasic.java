package LinkedList;

// Class can also be said as like a user built datatype which contains multiple data types.
class Node {
    Node pointNode;
    int value;
    String message;
}


public class LinkedListBasic {

    static void traveseLL(Node n) {

        while(true) {
            System.out.println(n.value);
            System.out.println(n.message);
            if (n.pointNode == null) break;
            else n = n.pointNode;
        }
    }

    static void addNodeInLast(Node node, int value, String message) {
        while (node.pointNode != null) {
            node = node.pointNode;
        }
        Node newNode = new Node();
        node.pointNode = newNode;
        newNode.value = value;
        newNode.pointNode = null;
        newNode.message = message;
    }

    static Node searchNode(Node node, int value) {
        while(node.value != value) {
            if (node.pointNode == null) {
                System.out.println("The required node is not available in the Linked List.");
                return null;
            }
            node = node.pointNode;
        }
        return node;

    }

    static void addNodeInIndex(Node node, int index, String message) {
        int nodeValue = index;
        while (index > 1) { // Choose 1, if argument index = 3, index 2 item points to index 3 where we want to add the item.
            node = node.pointNode;
            index--;
        }
        Node newNode = new Node();
        Node temp = node.pointNode;
        node.pointNode = newNode;
        newNode.pointNode = temp;
        newNode.value = nodeValue*10 + 10;
        newNode.message = message;
    }

    static Node deleteNodeByValue(Node node, int value) {

        if (node == null)
            return null;

        if (node.value == value)
            return node.pointNode;

        Node prev = node;
        Node curr = node.pointNode;

        while (curr != null && curr.value != value) {
            prev = curr;
            curr = curr.pointNode;
        }

        if (curr == null) {
            System.out.println("Node not found");
            return node;
        }

        prev.pointNode = curr.pointNode;
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node();
        Node node1 = new Node();
        Node node2 = new Node();

        head.value = 10;
        head.message = "Head1_message";
        head.pointNode = node1;

        node1.value = 20;
        node1.message = "node1_message";
        node1.pointNode = node2;

        node2.value = 30;
        node2.message = "node2_message";
        node2.pointNode = null;

        traveseLL(head);

        addNodeInLast(head, 40, "Hi Dude");
        addNodeInLast(head, 50, "Hello Dude, its 50");
        System.out.println("\nTraversing after adding the new node/s\n");
        traveseLL(head);

        addNodeInIndex(head, 3, "Hey this node is added in between");

        System.out.println("\nSearching Node...\n");
        Node searchedNode = searchNode(head, 30);
        System.out.println(searchedNode.message);

        System.out.println("\n");

        traveseLL(head);

        head = deleteNodeByValue(head, 30);  // What if the value is in the first node ? The head changes.

        traveseLL(head);

        Node searchedNode1 = searchNode(head, 30);
        if (searchedNode1 != null) {
            System.out.println(searchedNode1.message);
        }
    }
}  