package StackAndQueue;

public class Queue {
    private int[] arr;
    private int last;
    public Queue(int arrayLength) {
        arr = new int[arrayLength];
        last = -1;
    }
    private boolean isEmpty() {
        return last == -1;
    }
    private boolean isFull() {
        return last == arr.length - 1;
    }
    public int size() {
        return last + 1;
    }
    private void leftShiftArray() {
        for (int i = 0; i < last; i++) {
            arr[i] = arr[i+1];
        }
    }
    public void display() {
        int n = size();
        System.out.print("Front--> ");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(" -->Rear\n");
    }
    public void enqueue(int value) {
        if (isFull()) throw new IllegalStateException("\"Queue Overflow\"");
        arr[++last] = value;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("\"Queue Underflow\"");
        int val = arr[0];
        leftShiftArray();
        last--;
        return val;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(2);
        queue.display();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.display();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(33);
        queue.display();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
