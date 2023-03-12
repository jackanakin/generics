import java.util.HashSet;
import java.util.Set;

public class Run {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Odin");
        set.add("Zeus");
        set.add("Anubis");
        set.add("Seth");
        set.add("Atenas");
        set.add("Jupter");
        set.add("Odin");

        Set<String> set2 = new HashSet<>();
        set2.add("Odin");
        set2.add("Zeus");
        set2.add("Anubis");

        System.out.println(set.containsAll(set2));
        set.retainAll(set2);

        for (String s : set)
            System.out.println(s);
    }
}
