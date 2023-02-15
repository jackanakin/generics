class HashTable<K, V> {
    private K key;
    private V value;

    public HashTable(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "HashTable [key=" + key + ", value=" + value + "]";
    }
}

public class Run {
    public static void main(String[] args) {
        HashTable<Integer, String> table = new HashTable<>(1, "Generics");
        System.out.println(table);
    }
}
