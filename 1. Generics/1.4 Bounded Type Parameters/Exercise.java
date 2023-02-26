public class Exercise {

    public static <T extends Comparable<T>> int countGreaterItems(T[] input, T item) {
        int count = 0;

        for (T each : input) {
            if (item.compareTo(each) < 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Integer[] numbers1 = { 1, 2, 3, 4, 5 };
        Double[] numbers2 = { 1.4, 2.1, 3.9, 4.3, 5.1 };
        String[] strings = { "a", "b", "f", "d", "e" };

        System.out.println(countGreaterItems(numbers1, 3));
        System.out.println(countGreaterItems(numbers2, 2.0));
        System.out.println(countGreaterItems(strings, "c"));
    }
}
