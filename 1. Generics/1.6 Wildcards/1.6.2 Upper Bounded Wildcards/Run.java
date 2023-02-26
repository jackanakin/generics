import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Run {

    public static double sumAll(List<? extends Number> list) {
        double sum = 0;

        for (Number n : list)
            sum += n.doubleValue();

        return sum;
    }

    public static void showAll(List<? extends Number> list) {
        // we can only read
        list.forEach(item -> System.out.println(item));

        // not going to work since type is not guaranteed
        // list.add(1);
    }

    public static void main(String[] args) {

        List<? extends Number> l1 = new ArrayList<Integer>();
        List<? extends Number> l2 = new ArrayList<Double>();
        // List<? extends Number> l3 = new ArrayList<String>(); // WRONG

        showAll(l1);
        showAll(l2);
        showAll(Arrays.asList(1, 2, 3, 5));

    }

}
