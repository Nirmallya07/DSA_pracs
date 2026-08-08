package StackAndQueue;

public class CircularQueue {

    // Debugged it and completed the logic by my own.
    // May not be optimal.

    private int[] arr;
    private int capacity, front, rear, size;

    public CircularQueue(int arrayLength) {
        capacity = arrayLength;
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size =0;
    }

    private boolean isEmpty() {
//        if(front == 0 & rear == 0) return false;
//        return front == rear;
        return size == 0;
    }

    private boolean isFull() {
        return size == arr.length;
    }

    public void enqueue (int value) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        if (isEmpty()) {
            rear = front = 0;
            arr[rear] = value;
            size++;
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            rear = front = -1;
            throw new IllegalStateException("Queue Underflow");
        }
        int res = arr[front];
        front = (front+1) % capacity;
        size--;
        return res;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enqueue(3);
        circularQueue.enqueue(5);
        circularQueue.enqueue(8);
        circularQueue.enqueue(14);
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        circularQueue.enqueue(22);
        circularQueue.enqueue(23);
        System.out.println("Size: " + circularQueue.size);
        circularQueue.enqueue(33);
        System.out.println("Size: " + circularQueue.size);
        circularQueue.enqueue(41);
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        try {
            System.out.println(circularQueue.dequeue());
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
        circularQueue.enqueue(51);
        System.out.println(circularQueue.size);
    }

}
