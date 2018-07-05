import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<>();

        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");

        queue.add(queue.pop());
        queue.add(queue.pop());
        queue.add(queue.pop());
        queue.add(queue.pop());
    }
}
