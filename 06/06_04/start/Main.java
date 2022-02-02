import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        NonNegativeArrayList nonNegativeArrayList = new NonNegativeArrayList(-10, 2, 3, -2, 0);
        nonNegativeArrayList.add(-1);
        nonNegativeArrayList.add(9);
        System.out.println(nonNegativeArrayList);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-17);
        arrayList.add(11);
        arrayList.add(-5);
        System.out.println(arrayList);
    }
}
