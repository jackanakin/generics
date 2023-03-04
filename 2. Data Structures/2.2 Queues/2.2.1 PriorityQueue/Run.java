import java.util.PriorityQueue;
import java.util.Queue;

public class Run {
    public static void main(String[] args) {
        Queue<Person> queue = new PriorityQueue<>();

        queue.add(new Person("Thor", 2500));
        queue.add(new Person("Odin", 3000));
        queue.add(new Person("Loki", 2400));

        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }
    }
}
