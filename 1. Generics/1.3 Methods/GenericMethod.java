public class GenericMethod {
    public <T> void showItem(T item) {
        System.out.println("The item is: " + item);
    }

    public <T> T getItem(T item) {
        System.out.println("Returning item: " + item);
        return item;
    }

    public <T, V> void showMany(T t, V v) {
        System.out.println("T: " + t + ", V: " + v);
    }

    public <T> void printMany(T[] items) {
        for (T item : items) {
            System.out.println("Item is: " + item);
        }
    }

    public <T, V> boolean checkEquality(T t, V v) {
        return t.equals(v);
    }
}
