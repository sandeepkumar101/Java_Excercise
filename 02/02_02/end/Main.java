import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Optional<String> emptyOpt = Optional.empty();
        Optional<String> nameOpt = Optional.of("Kathryn");

//        if (emptyOpt.isPresent()) {
//            System.out.println("Hi " + nameOpt.get());
//        } else {
//            System.out.println("Hi");
//        }

        System.out.println("Hi " + nameOpt.orElse(""));
        System.out.println("Hi " + emptyOpt.orElse(""));
    }
}
