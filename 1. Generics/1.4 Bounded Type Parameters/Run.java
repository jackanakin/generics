class Person implements Comparable<Person> {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.getAge());
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class Run {
    public static <T extends Comparable<T>> T calcMin(T num1, T num2) {
        if (num1.compareTo(num2) < 0) {
            return num1;
        }
        return num2;
    }

    public static <T extends Number> double add(T num1, T num2) {
        double result = num1.doubleValue() + num2.doubleValue();

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calcMin(40, 60));
        
        System.out.println(calcMin("A", "B"));

        System.out.println(calcMin(new Person(18, "Jack"), new Person(25, "John")));

        System.out.println(add(40, 60));
    }
}
