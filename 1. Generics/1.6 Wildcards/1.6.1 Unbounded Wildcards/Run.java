import java.util.Arrays;
import java.util.List;

public class Run {

    // List<Number> is not going to compile
    // if we want to restrict this method to accept only numbers (float, double,
    // integer, etc...)
    public static void print(List<?> list) {
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }

    public static void main(String[] args) {
        // trying to restrict a method that only accepts Number
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        print(nums);

        // Unbounded wildcard
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String> ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);
    }

    // Unbounded wildcard
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        
        System.out.println();
    }

}
