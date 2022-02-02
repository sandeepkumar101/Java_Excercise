import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Declare an array
        int[] nums;

        // Declare and allocate an array
        double[] otherNums = new double[5];

        // Declare, allocate, and init an array
        String[] availablePets = {"cat", "dog", "fish"};
        String[] unavailablePets = {"bird", "rabbit", "hamster", "gerbil"};

        System.out.println(Arrays.toString(availablePets));
        System.out.println(Arrays.toString(unavailablePets));

        int indexOfAvailablePet = 2; // index of fish
        int indexOfUnavailablePet = 0; // index of bird

        String availablePet = availablePets[indexOfAvailablePet];
        String unavailablePet = unavailablePets[indexOfUnavailablePet];

        availablePets[indexOfAvailablePet] = unavailablePet;
        unavailablePets[indexOfUnavailablePet] = availablePet;

        System.out.println(Arrays.toString(availablePets));
        System.out.println(Arrays.toString(unavailablePets));
    }
}












