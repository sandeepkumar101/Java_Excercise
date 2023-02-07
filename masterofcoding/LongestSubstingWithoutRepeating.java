package  masterofcoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstingWithoutRepeating {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(solution(s));
        s = "bbbbb";
        System.out.println(solution(s));
        s = "pwwkew";
        System.out.println(solution(s));
        s = "umvejcuuk";
        System.out.println(solution(s));
        
    }
    public static int solution(String s)
    {
        if(s==null || s.length()<1)
        {
            return 0;
        }
        s = s.toLowerCase();
        //int[] chars = new int[26];
        //Arrays.fill(chars, 0);
        Map<Character,Integer> chars = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            if(chars.containsKey(c))
            {
                int index = chars.get(c);
                for(int i = left; i<index;i++)
                {
                    chars.remove(s.charAt(i));
                    left++;
                }
                left++;
            }
            chars.put(c, right);
            maxLength = Math.max(maxLength, right-left);
            right++;
        }
        return maxLength+1;
    }
    
}
