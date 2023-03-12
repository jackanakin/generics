import java.util.LinkedHashSet;
import java.util.Set;

public class Run {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();

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
