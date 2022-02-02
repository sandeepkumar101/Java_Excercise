public class Main {

    public static void main(String[] args) {
        // 0 1 2 3 4 5
        // A P P L E S
        String apples = "Apples";

        char firstCharacter = apples.charAt(0);
        System.out.println(firstCharacter);

        System.out.println(apples.indexOf('e'));

        String sub = apples.substring(2, 4);
        System.out.println(sub);

        System.out.println(apples.contains("App"));

        char[] applesArray = apples.toCharArray();
        int index = 4;
        System.out.println(applesArray[4]);
    }
}
