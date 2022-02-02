import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void printBinary(int n) {
        if (n <= 0) {
            System.out.println("Nothing to print\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(Integer.toBinaryString(i));
        }

        System.out.println();
    }

    public static void printBinaryUsingQueue(int n) {
        if (n <= 0) {
            System.out.println("Nothing to print\n");
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        for (int i = 1; i <= n; i++) {
            Integer current = queue.remove();
            System.out.println(current);

            queue.add(current * 10);
            queue.add(current * 10 + 1);
        }

        System.out.println();
    }

    public static void main(String[] args) {
//        printBinary(6);
//        printBinary(-9);
//        printBinary(0);
//        printBinary(2);
//        printBinary(10);

        printBinaryUsingQueue(6);
        printBinaryUsingQueue(-9);
        printBinaryUsingQueue(0);
        printBinaryUsingQueue(2);
        printBinaryUsingQueue(10);
    }

}












