package common;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
// is the substring is contigusous
// is the string case sensitive
// is the string anagram    //https://leetcode.com/problems/valid-anagram/

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "pwwkew";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }
    public static int lengthOfLongestSubstring(String s) {
        Queue<Character> q = new LinkedList<Character>();
        int max = 0;
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(q.contains(c))
            {
                while(q.peek()!=c)
                {
                    q.poll();
                }
                q.poll();
            }
            q.add(c);
            max = Math.max(max, q.size());
        }
        return max;
    }
}
