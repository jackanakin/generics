import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Run {

    public static <T> void copyT(List<? extends T> source, List<? super T> destination) {
        for (T object : source) {
            destination.add(object);
        }
    }

    public static void copy(List<? extends Number> source, List<? super Number> destination) {
        for (Number number : source) {
            destination.add(number);
        }
    }

    public static void main(String[] args) {
        List<? extends Number> source = Arrays.asList(1, 2, 3, 4, 5);
        List<? super Number> destination = new ArrayList<>();

        copyT(source, destination);

        System.out.println(destination);
    }
}
