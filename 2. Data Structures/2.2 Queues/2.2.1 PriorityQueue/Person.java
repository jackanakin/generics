public class Person implements Comparable<Person> {
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
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.getAge());
    }
}
