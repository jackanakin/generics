public class Run {
    public static void main(String[] args) {
        GenericMethod method = new GenericMethod();
        method.showItem(123);
        method.getItem("My Item");

        method.showMany(123, "Second item");

        Integer[] nums = { 1, 2, 3, 4, 5 };
        method.printMany(nums);

        String a = "checking equality";
        String a1 = "checking equality2";
        System.out.println("a=a1 ? " + method.checkEquality(a, a1));

        double b = 1.45;
        double b1 = 1.45;
        System.out.println("b=b1 ? " + method.checkEquality(b, b1));
    }
}
