import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Main1 {

    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList();
        students.add("Sally");
        students.add("Polly");
        students.add("Molly");
        students.add("Tony");

        students.forEach(System.out::println);

        students.forEach(s -> System.out.println(s));
        IntStream.range(0,students.size()).forEach( i -> System.out.println(students.get(i)));
        Iterator it = students.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // Consumer
        Consumer<String> printItem = n -> System.out.println(n);
        students.forEach(printItem);

        // Function
        Function<Integer, Integer> doubly = n -> n * n;
        System.out.println(doubly.apply(8));

        // Predicate (Return true or false)
        IntPredicate isDivByThree = n -> n%3 == 0;
        System.out.println(isDivByThree.test(3));

        // Supplier
        Supplier<Double> randomNumUnder100 = () -> Math.random() * 100;
        System.out.println(randomNumUnder100.get());
    }
}
