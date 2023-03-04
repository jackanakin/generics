import java.util.ArrayDeque;
import java.util.Deque;

public class Run {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(1);
        deque.offer(10);
        deque.offer(100);
        deque.offer(1000);

        System.out.println("Deque");
        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }

        Deque<Integer> stackDeque = new ArrayDeque<>();

        stackDeque.push(1);
        stackDeque.push(10);
        stackDeque.push(100);
        stackDeque.push(1000);

        System.out.println("StackDeque");
        while (!stackDeque.isEmpty()) {
            System.out.println(stackDeque.pop());
        }
    }
}