class Store {
    private Object item;

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}

public class App {

    public static void main(String[] args) {
        Store store = new Store();
        store.setItem(45.5);

        Integer item = (Integer) store.getItem(); // java.lang.ClassCastException
        System.out.println(item);
    }
}