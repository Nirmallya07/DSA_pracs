package LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

class cNode {
    int value;
    String message;
    cNode nextNode;

    cNode(int value, String message, cNode nextNode) {
        this.value = value;
        this.message = message;
        this.nextNode = nextNode;
    }
}


public class circularLL {

    static int totalElements = 0;

    static cNode createHeadNode(int value, String message) {
        cNode node = new cNode(value, message,null);
        node.nextNode = node;
        return node;
    }

    static cNode insertNode(cNode node, int value, String message, ArrayList<cNode> arr) {
        if ( node == null ) {
            node = createHeadNode(value, message);
            arr.clear();
            arr.add(node);
            totalElements = 1;
            return node; // returning null
        }

        cNode head = node;

        if ( node.nextNode == null) { // No use because of createHeadNode
            node.nextNode = head;
            return node;
        }

        while (node.nextNode != head) {
            node = node.nextNode;
        }

        cNode newNode = new cNode(value, message, head); // Next node is back pointing to head.

        node.nextNode = newNode;
        arr.add(newNode);
        totalElements++;
        return head;
    }

    static void arrayFy(cNode[] arr, cNode node, int startIndex) {
        // Only will use if array is used instead of an Array list.
    }

    static cNode indexInsertion(cNode header, int value, String message, ArrayList<cNode> arr, int index) {

        if (header == null) {
            System.out.println("Can't work with a null header.");
            return null;
        }

        cNode newNode = new cNode(value, message, null);

        if(index >= totalElements) {
            System.out.println("\nWARNING :: If input index is greater than total number of elements, it will be added to last !");
            System.out.println("Total number of elements :" + totalElements);
            System.out.println("It will be added at index :" + totalElements);
            Scanner scn = new Scanner(System.in);
            System.out.println("Type 'y' to add the element at last or type 'n' to terminate it. [Case Sensitive] :");
            String input = scn.nextLine();
            scn.close();
            if (input.equals("y")) {
                arr.getLast().nextNode = newNode;
                newNode.nextNode = header;
                arr.addLast(newNode);
                totalElements++;
                return header;
            } else if (input.equals("n")) {
                System.out.println("Insertion Terminated");
                return header;
            }
            else {
                System.out.println("Invalid input");
                return header;
            }
        }

        if (index == 0) {
            newNode.nextNode = header;
            header = newNode;
            arr.addFirst(newNode);
            arr.getLast().nextNode = arr.getFirst();
            totalElements++;
            return header;
        }
        cNode temp = header;
        int temp_index = index;
        while(temp_index > 1) {
            temp = temp.nextNode;
            temp_index--;
        }
        newNode.nextNode = temp.nextNode;
        temp.nextNode = newNode;
        arr.add(index, newNode);
        return header;
    }

    static void traverseCLL(cNode node) {
        cNode head = node;
        if (head == null) {
            System.out.println("No node is provided. Cannot Traverse without a node.");
            return;
        }
        if (head.nextNode == head) {
            System.out.println(head.value + ", " + head.message);
            return;
        }
        do {
            System.out.println(node.value + ", " + node.message);
            node = node.nextNode;
        } while (node != head);
    }

    static cNode reverseCLL(cNode node) {
        cNode head = node;
        cNode temp1 = node.nextNode;
        cNode temp2 = null;
        while (temp2 != head) {
            temp2 = temp1;
            temp1 = temp1.nextNode;
            temp2.nextNode = node;
            node = temp2;
        }
        return temp2.nextNode; // New head of the reversed list.
    }

    public static void main(String[] args) {

        cNode head = null;
        ArrayList<cNode> arr = new ArrayList<>();

        for ( int i = 0; i < 5; i++) {
            head = insertNode(head, i*10+10, "Message of Node " + (i+1) + " is Hello " + (i*10+1), arr);
        }
        traverseCLL(head);

        System.out.println("\nConstant Access time.....");

        cNode reqNode = arr.get(3);
        System.out.println(reqNode.value + ", " + reqNode.message);

        System.out.println("\n" + arr.getLast().value + " points too " + arr.getLast().nextNode.value);

        head = indexInsertion(head, 25, "Second index with value 25", arr, 2);
        traverseCLL(head);

        for ( int i = 0; i < arr.size(); i++) {
            System.out.println("\n" + arr.get(i).value + " points too " + arr.get(i).nextNode.value);
        }

        head = indexInsertion(head, 105, "35 at an index", arr, 32);
        head = indexInsertion(head, 32, "35 at an index", arr, 4);

        System.out.println("\nBefore Reversing.....");
        traverseCLL(head);

        cNode newHead = reverseCLL(head);
        System.out.println("\nReversing.....");
        traverseCLL(newHead);
        for ( int i = 0; i < arr.size(); i++) {
            System.out.println("\n" + arr.get(i).value + " points too " + arr.get(i).nextNode.value);
        }
        System.out.println(newHead.value);
    }
}