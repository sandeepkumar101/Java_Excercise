package masterofcoding;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/backspace-string-compare/
 * 
 * Given two strings s and t, return true if they are equal when both are typed
 * into empty text editors. '#' means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 * 
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 * 
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        String str = "ab#c";
        System.out.println(claen(str));
        str = "ab##";
        System.out.println(claen(str));
        str = "a#c";
        System.out.println(claen(str));
        str = "a####c";
        System.out.println(claen(str));
    }

    public static String claen(String str) {
        char hashTag = '#';
        char[] chars = new char[str.length()];
        int index = 0;
        int backspace = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == hashTag) {
                backspace++;
            } else {
                if (backspace > 0) {
                    backspace--;
                } else {
                    chars[index] = str.charAt(i);
                    index++;
                }
            }
        }
        char[] chars1 = new char[index];
        for (int i = index - 1, j = 0; i >= 0; i--, j++) {
            chars1[j] = chars[i];
        }
        return String.copyValueOf(chars1);
    }
}
