package common;

public class BinarySum {

    public static String solution(String a, String b) {

        int index = Math.max(a.length(), b.length()) - 1;
        StringBuilder binaryBum = new StringBuilder("");
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            int aDigit = 0;
            if (aIndex >= 0) {
                // Get the int value of the char
                aDigit = a.charAt(aIndex) - '0';
                aIndex--;
            }
            int bDigit = 0;
            if (bIndex >= 0) {
                // Get the int value of the char
                bDigit = b.charAt(bIndex) - '0';
                bIndex--;
            }

            int sum = carry + aDigit + bDigit;
            carry = sum / 2;
            binaryBum.append(sum % 2);
        }
        System.out.println(binaryBum);
        if (carry > 0) {
            binaryBum.append(carry);
        }
        System.out.println(binaryBum);
        return binaryBum.reverse().toString();

    }

    public static void main(String args[]) {
        String a = "1", b = "1";

        System.out.println(solution(a, b));
    }
}
