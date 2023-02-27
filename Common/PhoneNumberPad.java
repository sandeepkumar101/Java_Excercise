package Common;
//https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:
// Input: digits = ""
// Output: []
// Example 3:
// Input: digits = "2"
// Output: ["a","b","c"]
public class PhoneNumberPad {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        letterCombinations(digits, 0, "", result, map);
        return result;
    }

    private static void letterCombinations(String digits, int index, String current, List<String> result,
            Map<Character, String> map) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        String charset = map.get(digits.charAt(index));
        for (int i = 0; i < charset.length(); i++) {
            // String letter = String.valueOf(charset.charAt(i));
            letterCombinations(digits, index + 1, current + charset.charAt(i), result, map);
        }
        return;
    }

    
}
