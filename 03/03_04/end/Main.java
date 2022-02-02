import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String text = "The giant panda has an insatiable appetite for bamboo. " +
                "A typical animal eats half the day—a full 12 out of every 24 " +
                "hours—and relieves itself dozens of times a day. It takes 28 " +
                "pounds of bamboo to satisfy a giant panda's daily dietary needs. " +
                "Pandas will sometimes eat birds or rodents as well.";

        String[] sentences = text.split("\\. ");

        System.out.println("The text has " + sentences.length + " sentences.");

        String[] words = text.split(" |-");
        System.out.println("The text has " + words.length + " words.");

        System.out.println(Arrays.asList(words));

        System.out.println("The text has " + text.length() + " characters.");


    }
}
