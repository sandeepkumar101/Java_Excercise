package Common;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "abdbca", t = "abc";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow1(String s, String t) {
        // String sl = s.toLowerCase();
        // String tl = t.toLowerCase();
        int li = -1;
        int ri = -1;
        boolean[] bsarray = new boolean[128];
        int[] bsiarray = new int[128];
        boolean[] btarray = new boolean[128];

        if (s.length() < t.length()) {
            return "";
        }

        if (s.equals(t)) {
            return t;
        }

        for (int i = 0; i < t.length(); i++) {
            btarray[t.charAt(i)] = true;
        }

        int left = 0;
        int right = 0;
        // if (btarray[sl.charAt(left)]) {
        // bsiarray[sl.charAt(left)]++;
        // bsarray[sl.charAt(left)] = bsiarray[sl.charAt(left)] > 0 ? true : false;

        // }
        while (left <= right && right < s.length()) {
            if (!btarray[s.charAt(left)]) {
                while (left < s.length()) {
                    if (btarray[s.charAt(left)]) {
                        break;
                    }
                    left++;
                }
            }
            if (left < s.length()) {
                if (right < left) {
                    right = left;
                }

                if (btarray[s.charAt(right)]) {
                    bsiarray[s.charAt(right)]++;
                    bsarray[s.charAt(right)] = bsiarray[s.charAt(right)] > 0 ? true : false;
                }

                if (Arrays.equals(bsarray, btarray)) {
                    if (ri - li == 0 || ri - li > right - left) {
                        ri = right;
                        li = left;
                    }
                    bsiarray[s.charAt(left)]--;

                    bsarray[s.charAt(left)] = bsiarray[s.charAt(left)] > 0 ? true : false;
                    left++;

                }
                if (right + 1 < s.length())
                    right++;
            }
        }
        return li + ri >= 0 ? s.substring(li, ri + 1) : "";
    }

    // Good one
    public static String minWindow2(String s, String t) {
        int start = 0;
        int end = 0;
        Map<Character, Integer> patternSet = new HashMap<>();
        IntStream intStream = t.chars();
        intStream.mapToObj(c -> (char) c).forEach(e -> patternSet.put(e, 0));
        int count = 0;
        while (end < s.length()) {
            char toAdd = s.charAt(end);
            // end++;
            if (patternSet.containsKey(toAdd) && patternSet.get(toAdd) == 0) {
                count++;
                patternSet.put(toAdd, 1);
            }

            if (count == 1) {
                start = end;
            }
            end++;
            if (count == t.length()) {
                return s.substring(start, end);
            }

        }

        return "";
    }

    // Good two
    public static String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        int[] patterArray = new int[26];
        IntStream intStream = t.chars();
        intStream.mapToObj(c -> (char) c).forEach(e -> patterArray[e - 'a'] = 1);

        int count = 0;
        while (end < s.length()) {
            char toAdd = s.charAt(end);

            if (patterArray[toAdd - 'a'] == 1) {
                count++;
                patterArray[toAdd - 'a'] = 0;
            }
            if (count == 1) {
                start = end;
            }

            end++;

            if (count == t.length()) {
                return s.substring(start, end);
            }

        }
        return "";
    }

}
