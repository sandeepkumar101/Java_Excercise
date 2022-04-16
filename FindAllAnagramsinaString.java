import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {

    public static void main(String[] args) {
        String s = "abab";
        String s1 = "ab";
        System.out.println(findAnagrams1(s, s1));
    }

    public static List<Integer> findAnagrams2(String s, String p) {
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

    public static List<Integer> findAnagrams1(String s, String p) 
    {
        //Anagram Map
        Map<Character, Integer> anagramMap = new HashMap<>();
        for(int i = 0; i < p.length(); i++)
        {
            anagramMap.put(p.charAt(i), anagramMap.getOrDefault(p.charAt(i),0)+1);
        }

        int start = 0;
        int end = 0;
        //Map<Character, Integer> originMap = new HashMap<>();
        List<Integer> anagramList = new ArrayList<>();
        int count = 0;
        while(end< s.length())
        {
            char toAdd = s.charAt(end);
            end++;
            if(anagramMap.containsKey(toAdd))
            {
                //originMap.put(toAdd, originMap.getOrDefault(toAdd,0)+1);
                count++;
            }

            if(count == p.length())
            {
                anagramList.add(start);
            }

            if(end - start >= p.length())
            {
                char toRemove = s.charAt(start);
                start++;
                if(anagramMap.containsKey(toRemove))
                {
                    //originMap.put(toRemove, originMap.getOrDefault(toRemove,0)-1);
                    count--;
                }
            }
        }

        return anagramList;
        
    }

}
