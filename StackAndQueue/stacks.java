package StackAndQueue;

public class stacks {
    static int top = -1;
    static void push(int value, int[] arr, int length) {
        if (top == length-1) {
            System.out.println("Stack Overflow, top: " + top);
            return;
        }
        top++;
        arr[top] = value;
    }
    static int pop(int[] arr) {
        if (top == -1) {
            System.out.println("Stack Underflow, top :" + top);
            return -1;
        }
        int res = arr[top];
        top--;
        return res;
    }
    static void peek(int[] arr) {
        if (top == -1) {
            System.out.println("No elements at the stack");
            return;
        }
        System.out.println(arr[top]);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        push(5, arr, arr.length);
        push(10, arr, arr.length);
        push(8, arr, arr.length);
        push(2, arr, arr.length);
        System.out.println(pop(arr));
        push(4, arr, arr.length);
        push(11, arr, arr.length);
        System.out.println(pop(arr));
        peek(arr);
        push(43, arr, arr.length);
        push(51, arr, arr.length);
        push(14, arr, arr.length);
        push(42, arr, arr.length);
        System.out.println(pop(arr));
        System.out.println(pop(arr));
        System.out.println(pop(arr));
        peek(arr);
        push(22, arr, arr.length);
        push(19, arr, arr.length);
        push(71, arr, arr.length);
        push(77, arr, arr.length);
        push(101, arr, arr.length);
        push(33, arr, arr.length);
        peek(arr);
        System.out.println(pop(arr));
        System.out.println(pop(arr));
        System.out.println(pop(arr));
        peek(arr);
        System.out.println(pop(arr));
        System.out.println(pop(arr));
        System.out.println(pop(arr));
        peek(arr);
        System.out.println(pop(arr));
        System.out.println(pop(arr));
        System.out.println(pop(arr));
        peek(arr);
        push(33, arr, arr.length);
        int res = pop(arr);
        System.out.println(res);
        System.out.println(pop(arr));
        System.out.println(pop(arr));
        System.out.println(pop(arr));
    }
}