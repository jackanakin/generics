import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Run {
    public static void main(String[] args) {
        System.out.println("Example 1");
        example1();
        System.out.println("---------");

        System.out.println("Example 2");
        example2();
        System.out.println("---------");
    }

    private static void example2() {
        // O(1) < O(logN)
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());

        map.put(10, "Odin");
        map.put(3, "Thor");
        map.put(5, "Zeus");
        map.put(1, "Loki");
        map.put(8, "Atenas");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static void example1() {
        // O(1) < O(logN)
        Map<Integer, String> map = new TreeMap<>();

        map.put(10, "Odin");
        map.put(3, "Thor");
        map.put(5, "Zeus");
        map.put(1, "Loki");
        map.put(8, "Atenas");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}