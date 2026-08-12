package StackAndQueue;
import java.util.Stack;
public class JCF_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(5);
        stack.push(9);
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.search(5)); // 1 (from top : 1 pos (1-index based))
        stack.push(22);
        System.out.println(stack.search(5));// 2 ( Now 5 is at 2 pos from top)
    }
}
