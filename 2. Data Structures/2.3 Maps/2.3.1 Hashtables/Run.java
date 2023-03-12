import java.util.HashMap;
import java.util.Map;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name=" + this.name + ";Age=" + this.age;
    }

    @Override
    public int hashCode() {
        // hashCode = hash-function
        // it calculates an array index based on the key (keys == Person objects)
        int hashResult = super.hashCode();
        System.out.println(toString() + ";hash=" + hashResult);
        return hashResult;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

public class Run {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();

        map.put(new Person("Odin", 3000), "Odin");
        map.put(new Person("Zeus", 3000), "Zeus");
        map.put(new Person("Odin", 3000), "Odin2");
    }
}