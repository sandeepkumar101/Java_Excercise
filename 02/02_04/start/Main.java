import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // Create a stream
        Stream<String> shoppingStream = Stream.of("apples",
                "bananas", "cherries", "coffee");


        // Create a stream from other collection types
        // -------------------------------------------

        // Array
        String[] shoppingArray = new String[]{"apples",
                "bananas", "cherries", "coffee"};
        Stream<String> shoppingArrayStream = Arrays.stream(shoppingArray);

        // Lists
        List<String> shoppingList = List.of("apples",
                "bananas", "cherries", "coffee");
        Stream<String> shoppingListStream = shoppingList.stream();
    }
}
