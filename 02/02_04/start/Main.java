import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // Create a stream
        Stream<String> shoppingStream = Stream.of("apples",
                "bananas", "cherries", "coffee");

        Stream<String> strstm = Stream.of("wer","er","ert","dss");

        // Create a stream from other collection types
        // -------------------------------------------

        // Array
        String[] shoppingArray = new String[]{"apples",
                "bananas", "cherries", "coffee"};
        Stream<String> shoppingArrayStream = Arrays.stream(shoppingArray);

        String[] strary = new String[]{"wer","er","ert","dss"};
        Stream<String> strartstm = Arrays.stream(strary); 
        // Lists
        List<String> shoppingList = List.of("apples",
                "bananas", "cherries", "coffee");
        Stream<String> shoppingListStream = shoppingList.stream();
        shoppingListStream.forEach(System.out::println);

        //shoppingListStream.parallel().forEach(System.out::println);

        // match
        boolean mayMatch = shoppingListStream.anyMatch(t -> t.equals("apples"));

        
    }
}
