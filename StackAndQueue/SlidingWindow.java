// GPT Rating : 9.5
package StackAndQueue;

class Circular_Queue {
    private final int capacity;
    private int size;
    private int front, rear;
    private int[] arr;
    public Circular_Queue(int arrayLength) {
        arr = new int[arrayLength];
        front = rear = -1;
        size = 0;
        capacity = arrayLength;
    }
    private boolean isEmpty() {
        return size == 0;
    }
    private boolean isFull() {
        return size == capacity;
    }
    public void enqueue(int value) {
        if(isFull()) {
            System.out.println("Queue Overflow.");
            return;
        }
        if(isEmpty()) {
            front = rear = 0;
            arr[rear] = value;
            size = 1;
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }
    public void dequeue() {
        if(isEmpty()) {
            System.out.println("Queue Underflow.");
            return;
        }
        front = (front + 1) % capacity;
        size--;
        if(size == 0) rear = front = -1;
    }
    public void displayQueue() {
        int temp = front;
        int count = size;
        System.out.print("[ ");
        while(count != 0) {
            System.out.print(arr[temp] + " ");
            temp = (temp + 1) % capacity;
            count--;
        }
        System.out.println("]");
    }
}

public class SlidingWindow {
    private int[] arr;
    private int windowSize;
    public SlidingWindow(int[] arr, int windowSize) {
        this.arr = arr;
        this.windowSize = windowSize;
    }
    public void displaySlidingWindow() {
        Circular_Queue circularQueue = new Circular_Queue(windowSize);
        for(int index = 0; index < windowSize; index++) {
            circularQueue.enqueue(arr[index]);
        }
        circularQueue.displayQueue();
        int index = windowSize;
        while(index < arr.length) {
            circularQueue.dequeue();
            circularQueue.enqueue(arr[index]);
            circularQueue.displayQueue();
            index++;
        }
        int k = windowSize;
        while(k != 1) {
            circularQueue.dequeue();
            circularQueue.displayQueue();
            k--;
        }
        System.out.println("[ Queue is Empty ]");
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 5, 6, 9, 0, 1, 22, 14};
        int window_size = 3;
        SlidingWindow slidingWindow = new SlidingWindow(arr, window_size);
        slidingWindow.displaySlidingWindow();
    }
}
