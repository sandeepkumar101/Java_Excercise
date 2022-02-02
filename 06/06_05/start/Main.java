import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> nonNegativeArrayList =
                new NonNegativeArrayList(-10, 2, 3, -2, 0);

        nonNegativeArrayList.add(-1);
        nonNegativeArrayList.add(9);
        System.out.println(nonNegativeArrayList);
    }
}
