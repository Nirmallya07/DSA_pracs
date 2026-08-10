// Double Ended Queue

package StackAndQueue;

class TraverseQueue {
//    int front, rear;
//    int[] arr;
//    public TraverseQueue(int front, int rear, int[] arr) {
//        this.front = front;
//        this.rear = rear;
//        this.arr = arr;
//        traverse();
//    }
    public void traverse(int front, int rear, int[] arr) {
        if(front == -1 || rear == -1) {
            System.out.println("The Dequeue is empty.");
            return;
        }
        if(front == rear) {
            System.out.println(arr[front]);
            return;
        }
        int capacity = arr.length;
        System.out.print("Front--> ");
        while (front != rear) {
            System.out.print(arr[front] + " ");
            front = (front + 1) % capacity;
        }
        System.out.print(arr[front] + " ");
        System.out.println("<--Rear");
    }
}

public class Dequeue extends TraverseQueue {
    private int front, back, size;
    private int[] arr;
    private final int capacity;

    public Dequeue(int arrayCapacity) {
        arr = new int[arrayCapacity];
        capacity = arrayCapacity;
        front = back = -1;
        size = 0;
    }

    public int getFront() {
        return front;
    }

    public int getBack() {
        return back;
    }

    public int getSize() {
        return size;
    }

    public int[] getArr() {
        return arr.clone();
    }

    public void callTraverse() {
        traverse(front, back, getArr());
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    public void backPush(int value) {
        if(isFull()) {
            System.out.println("Dequeue Overflow.");
            return;
        }
        if(isEmpty()) {
            front = back = 0;
            arr[back] = value;
            size = 1;
            return;
        }
        back = (back + 1) % capacity;
        arr[back] = value;
        size++;
    }

    public int frontPull() {
        if(isEmpty()) {
            throw new IllegalStateException("Dequeue Underflow.");
        }
        int res = arr[front];
        front = (front + 1) % capacity;
        size--;
        if(size == 0) front = back = -1;
        return res;
    }

    public void frontPush(int value) {
        if(isFull()) {
            System.out.println("Queue Overflow.");
            return;
        }
        if(isEmpty()) {
            front = back = 0;
            arr[front] = value;
            size = 1;
            return;
        }
        front = (front - 1) % capacity;
        if (front == -1) front = capacity - 1;
        arr[front] = value;
        size++;
    }

    public int backPull() {
        if(isEmpty()) {
            throw new IllegalStateException("Dequeue Underflow.");
        }
        int res = arr[back];
        back = (back - 1) % capacity;
        if(back == -1) back = capacity - 1;
        size--;
        if(size == 0) front = back = -1;
        return res;
    }

    public static void main(String[] args) {
        Dequeue dequeue = new Dequeue(5);
//        TraverseQueue traverseQueue = new TraverseQueue(dequeue.getFront(), dequeue.getBack(), dequeue.getArr());
        dequeue.backPush(3);
        dequeue.backPush(5);
        dequeue.frontPush(9);
        dequeue.backPush(10);
        dequeue.frontPush(23);
        dequeue.callTraverse();
        System.out.println(dequeue.frontPull());
        System.out.println(dequeue.backPull());
        System.out.println(dequeue.backPull());
        System.out.println(dequeue.frontPull());
        dequeue.callTraverse();
        dequeue.frontPush(4);
        dequeue.backPush(30);
        dequeue.frontPush(33);
        dequeue.backPush(32);
        dequeue.backPush(51);
        dequeue.callTraverse();
        System.out.println(dequeue.backPull());
        System.out.println(dequeue.backPull());
        System.out.println(dequeue.frontPull());
        System.out.println(dequeue.frontPull());
        System.out.println(dequeue.frontPull());
        dequeue.callTraverse();
        try {
            System.out.println(dequeue.frontPull());
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
        try {
            System.out.println(dequeue.backPull());
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
    }
}

