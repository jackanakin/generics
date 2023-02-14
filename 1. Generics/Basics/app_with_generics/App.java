class Store<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

public class App {

    public static void main(String[] args) {
        Store<Double> store = new Store<>();
        store.setItem(45.5);

        double item = store.getItem();
        System.out.println(item);
    }
}