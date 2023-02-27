package Common;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationinString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "abc";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1count = new int[26];
        for (char c : s1.toCharArray()) {
            s1count[c - 'a']++;
        }
        int[] s2count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s2count[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1count, s2count)) {
            return true;
        }

        int start = s1.length();
        while (start < s2.length()) {
            s2count[s2.charAt(start - s1.length()) - 'a']--;
            s2count[s2.charAt(start) - 'a']++;
            if (Arrays.equals(s1count, s2count)) {
                return true;
            }

            start++;
        }
        return false;
    }

}
