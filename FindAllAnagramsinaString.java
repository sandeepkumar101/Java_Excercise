import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsinaString {

    public static void main(String[] args) {
        String s = "abab";
        String s1 = "ab";
        System.out.println(findAnagrams(s, s1));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length())
            return res;
        s = s.toLowerCase();
        p = p.toLowerCase();

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        int start = 0;
        if (Arrays.equals(pCount, sCount)) {
            res.add(start);
        }

        int end = p.length();
        while (end <= s.length() - 1) {
            sCount[s.charAt(start) - 'a']--;
            sCount[s.charAt(end) - 'a']++;
            start++;
            end++;
            if (Arrays.equals(pCount, sCount)) {
                res.add(start);
            }

        }
        return res;
    }
}
