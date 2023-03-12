import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Run {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(Comparator.reverseOrder());

        set.add("Odin");
        set.add("Zeus");
        set.add("Anubis");
        set.add("Seth");
        set.add("Atenas");
        set.add("Jupter");
        set.add("Odin");

        for (String s : set)
            System.out.println(s);
    }
}
