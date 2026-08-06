package StackAndQueue;

public class Stack {

    private int[] arr;
    private int top;

    Stack(int arrayLength) {
        arr = new int[arrayLength];
        top = -1;
    }

    private boolean isFull() {
        return top == arr.length - 1;
    }
    private boolean isEmpty() {
        return top == -1;
    }
    public int size() {
        return top + 1;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty.");
            return;
        }
        System.out.print("Top --> ");
        int n = size();
        for (int i = n-1; i > 0; i--) System.out.print(arr[i] + " ");
        System.out.println();
    }
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow, top: " + top);
            return;
        }
        top++;
        arr[top] = value;
    }
    public int pop()  {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow, top :" + top);
        }
        int res = arr[top];
        top--;
        return res;
    }
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow, top : + top");
        }
        return arr[top];
    }

    public static void main(String[] args) {

        Stack stack = new Stack(10);
        System.out.println("jjj");
        stack.display();
        System.out.println("jj");
        stack.push(5);
        stack.push(10);
        stack.push(8);
        stack.push(2);

        System.out.println("Popped: " + stack.pop());

        stack.push(4);
        stack.push(11);

        System.out.println("Popped: " + stack.pop());

        System.out.println("Top Element: " + stack.peek());

        stack.display();

        stack.push(43);
        stack.push(51);
        stack.push(14);
        stack.push(42);
        stack.push(22);
        stack.push(19);
        stack.push(71);

        stack.display();

        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        try {
            stack.pop(); // This will create underflow.
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("Programme complete");
    }
}