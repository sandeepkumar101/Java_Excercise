import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Optional<String> emptyOpt = Optional.empty();
        Optional<String> nameOpt = Optional.of("Kathryn");
        //Optonal<String> nullOpt = Optional.ofNullable(null);
        emptyOpt.ifPresent(System.out::println);
        nameOpt.ifPresent(System.out::println);
        nameOpt.ifPresent( t -> System.out.println(t));
        System.out.println(emptyOpt.orElse("No name"));
        //nullOpt.ifPresent(System.out::println);
    }
}
