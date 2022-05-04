package Common;
import java.util.*;

class StringPermutation {
    public static void main(String[] args) {
        System.out.println(findPermutation1("bcdxabcdy", "cdyabcdx"));
    }

    public static boolean findPermutation1(String str, String pattern) {
        // TODO: Write your code here
        Map<Character, Integer> patternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int start = 0;
        int count = 0;
        Map<Character, Integer> patternStr = new HashMap<>();
        int end = 0;
        while (end < str.length()) {
            char toAdd = str.charAt(end);
            patternStr.put(toAdd, patternStr.getOrDefault(toAdd, 0) + 1);
            end++;
            if (patternMap.containsKey(toAdd) && patternMap.get(toAdd).intValue() == patternStr.get(toAdd).intValue())
                count++;

            if (count == patternMap.size())
                return true;

            if (end - start >= pattern.length()) {

                char toRemove = str.charAt(start);
                if (patternMap.containsKey(toRemove)
                        && patternMap.get(toRemove).intValue() == patternStr.get(toRemove).intValue())
                    count--;

                patternStr.put(toRemove, patternStr.getOrDefault(toRemove, 0) - 1);
                start++;
            }
           

        }
        return false;
    }

    public static boolean findPermutation(String str, String pattern) {
        // TODO: Write your code here
        int[] patternArray = new int[26];
        int[] strArray = new int[26];

        for (int i = 0; i < pattern.length(); i++) {
            patternArray[pattern.charAt(i) - 'a']++;
            strArray[str.charAt(i) - 'a']++;
        }
        int start = 0;

        if (Arrays.equals(patternArray, strArray))
            return true;

        for (int i = pattern.length(); i < str.length(); i++, start++) {

            strArray[str.charAt(i) - 'a']++;
            strArray[str.charAt(start) - 'a']--;

            if (Arrays.equals(patternArray, strArray))
                return true;

        }
        return Arrays.equals(patternArray, strArray);
    }

}
