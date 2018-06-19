package p06_stackOfStrings;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
