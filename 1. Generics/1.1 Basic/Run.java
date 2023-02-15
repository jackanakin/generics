class Store {
    private Object item;

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}

class StoreGeneric<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

public class Run {

    public static void main(String[] args) {
        // Withou generics
        Store store = new Store();
        store.setItem(45.5);

        Integer item = (Integer) store.getItem(); // java.lang.ClassCastException
        System.out.println(item);
        ///////////////////////////////

        ///////////////////////////////
        // With generics
        StoreGeneric<Double> genericStore = new StoreGeneric<>();
        store.setItem(45.5);

        double item2 = genericStore.getItem();
        System.out.println(item2);
    }
}