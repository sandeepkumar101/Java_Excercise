public class Main {

    public static void main(String[] args) {
        String literalA = "abc";
        String literalB = "abc";

        String objectA = new String("abc");
        String objectB = new String("abc");

        System.out.println(literalA == objectA);
        System.out.println(literalA == objectB);
        System.out.println(literalA == literalB);
    }
}
