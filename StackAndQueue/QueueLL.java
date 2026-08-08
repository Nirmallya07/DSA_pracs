//Gpt Rating = 9.3
package StackAndQueue;

public class QueueLL {

    private int size = 0;
    private Node front = null, rear = null;

    private class Node {
        int value;
        Node next;
        Node (int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int value) {

        if(isEmpty()) {
            Node node = new Node(value, null);
            rear = front = node;
            size = 1;
            return;
        }
        Node node = new Node(value, null);
        rear.next = node;
        rear = node;
        size++;
    }

    public Node dequeue() {

        if(isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        Node res = front;
        front = front.next;
        size--;
        return res;
    }

    public void displayQueue() {
        if(isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }
        Node cuurNode = front;
        System.out.print("Front--> ");
        while(cuurNode != null) {
            System.out.print(cuurNode.value + " ");
            cuurNode = cuurNode.next;
        }
        System.out.println(" <--Rear");
    }

    public static void main(String[] args) {
        QueueLL queueLL = new QueueLL();
        // Since, main is inside QueueLL class, so we can change the private variables.
//        System.out.println(queueLL.size);
//        queueLL.size = 2;
//        System.out.println(queueLL.size);
        queueLL.enqueue(2);
        queueLL.enqueue(5);
        queueLL.enqueue(33);
        queueLL.enqueue(42);
        queueLL.enqueue(22);
        queueLL.enqueue(3);
        queueLL.displayQueue();
        queueLL.dequeue();
        queueLL.dequeue();
        queueLL.displayQueue();
        queueLL.enqueue(55);
        queueLL.displayQueue();
        queueLL.dequeue();
        queueLL.dequeue();
        queueLL.dequeue();
        queueLL.dequeue();
        queueLL.dequeue();
        queueLL.displayQueue();
        queueLL.dequeue();
    }
}