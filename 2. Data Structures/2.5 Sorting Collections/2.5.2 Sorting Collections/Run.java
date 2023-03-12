import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Run {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Odin");
        list.add("Anubis");
        list.add("Mars");
        list.add("Jupter");
        list.add("Atenas");

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}