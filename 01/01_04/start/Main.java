public class Main {

    public static void main(String[] args) {
        System.out.println(Dice.sidesOfDice);

        Dice myFirstDice = new Dice();
        Dice myOtherDice = new Dice();

        System.out.println();

        for(int i = 0; i < 10; i++) {
            System.out.println("First Dice: " + myFirstDice.roll());
            System.out.println("Second Dice: " + myOtherDice.roll());
        }

        System.out.println();

        System.out.println("1st Face: " + myFirstDice.getFaceValue());
        System.out.println("Other Face: " + myOtherDice.getFaceValue());
    }
}
