package Common;

import java.util.Arrays;
//Hired Assessments
public class LongestNonRepeatSubString {
    public static void main(String[] args) {
        String s = "nndNfdfdf";
        System.out.println(solution(s));
    }

    public static long solution(String s) {
        s = s.toLowerCase();
        int[] charArray = new int[26];
        Arrays.fill(charArray, 0);
        int left = 0;
        int right = 1;
        int max = 0;
        charArray[s.charAt(0) - 'a'] = 1;
        while (right < s.length()) {
            charArray[s.charAt(right) - 'a'] = charArray[s.charAt(right) - 'a'] + 1;
            if (charArray[s.charAt(right) - 'a'] > 1) {
                while (charArray[s.charAt(left) - 'a'] != charArray[s.charAt(right) - 'a'] && left < right) {
                    charArray[s.charAt(left) - 'a'] = charArray[s.charAt(left) - 'a'] - 1;
                    left++;
                }
                charArray[s.charAt(left) - 'a'] = charArray[s.charAt(left) - 'a'] - 1;
            }
            max = Math.max(max, right - left);
            right++;
        }
        // Type your solution here
        return max;
    }
}
