import java.util.ArrayList;
import java.util.List;

public class Run {

    public static void showAll(List<? super Number> list) {
        list.forEach(num -> System.out.println(num));
    }

    public static void main(String[] args) {
        List<? super Integer> l1 = new ArrayList<Integer>();
        List<? super Integer> l2 = new ArrayList<Number>();
        List<? super Integer> l3 = new ArrayList<Object>();

        // insert items
        List<? super Number> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1.1f);
        nums.add(1.1d);
    }
}
