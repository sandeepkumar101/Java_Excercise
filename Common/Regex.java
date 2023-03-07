package Common;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Regex {

    public static void main(String[] args) {
        String[] strings = { "a", "aba", "aa", "ab", "ab", "aab", "aaa", "aaaaaa" };
        String[] patters = { "ab*a", "ab", "a*", ".*", ".", "c*a*b", "a*.", "a*aa" };
        
          for (int i = 0; i < strings.length; i++) {
          System.out.println(isMatch(strings[i], patters[i]));
          }
          System.out.println("");
          for (int i = 0; i < strings.length; i++) {
          //System.out.println(isMatch1(strings[i], patters[i]));
          }
          System.out.println("");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(isMatchWithstack(strings[i], patters[i]));
        }
        System.out.println("");
        for (int i = 0; i < strings.length; i++) {
             System.out.println(isMatch3(0,strings[i],0, patters[i]));
             }
    }

    /**
     * write a method that takes two string as arguments:
     * s (a string to match againt) and p ( a pattern)
     * and return a boolean denoting whether s matches p.
     * p can be any number of the following:
     * 1. a-z which stand for itself
     * 2. '.' which stand for any character
     * 3. '*' which must follow another single character and stand for 0 or more
     * occurence of that character
     * 
     * s = "aba", p = "ab" => false
     * s = "aa" , p = "a*" => true
     * s = "ab" , p = ".*" => true
     * s= "ab" , p = '.' => false
     * s ="aab", p = "c*a*b" => true
     * s = "aaa", p = "a*." => true
     * 
     * Example 1:
     * 
     * Input: s = "aa", p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     * Example 2:
     * 
     * Input: s = "aa", p = "a*"
     * Output: true
     * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore,
     * by repeating 'a' once, it becomes "aa".
     * Example 3:
     * 
     * Input: s = "ab", p = ".*"
     * Output: true
     * Explanation: ".*" means "zero or more (*) of any character (.)".
     * 
     * https://leetcode.com/problems/regular-expression-matching/description/
     * 
     */

    public static boolean isMatch(String s, String p) {
        char a = 'a';
        char z = 'z';
        char dot = '.';
        char star = '*';
        int i = 0, j = 0;
        while (i < p.length() && j < s.length()) {
            char patternChar = p.charAt(i);
            char stringChar = s.charAt(j);
            if (i + 1 < p.length() && p.charAt(i + 1) == star) {
                // '*'
                if (a <= patternChar && patternChar <= z) {
                    while (j < s.length() && s.charAt(j) == patternChar) {
                        j++;
                    }

                } else if (patternChar == dot) {
                    while (j < s.length()) {
                        j++;
                    }

                }
                i++;
            }
            // a-z
            else if (a <= patternChar && patternChar <= z) {
                if (patternChar != stringChar) {
                    return false;
                }
                j++;
            }
            // '.'
            else if (patternChar == dot) {
                j++;
            }
            i++;
        }
        if (i < p.length() && (p.charAt(i) >= a && p.charAt(i) <= z)) {
            return false;
        }
        if (j < s.length()) {
            return false;
        }
        return true;
    }

    public static boolean isMatch1(String s, String p) {
        char a = 'a';
        char z = 'z';
        char dot = '.';
        char star = '*';
        int i = p.length() - 1, j = s.length() - 1;
        while (i >= 0 && j >= 0) {
            char patternChar = p.charAt(i);
            char stringChar = s.charAt(j);
            if (patternChar == star) {
                patternChar = p.charAt(--i);
                // '*'
                if (a <= patternChar && patternChar <= z) {
                    while (j >= 0 && s.charAt(j) == patternChar) {
                        j--;
                    }

                } else if (patternChar == dot) {
                    return true;
                    /*
                     * while (j >= 0) {
                     * j--;
                     * }
                     */

                }
                // i--;
            }
            // a-z
            else if (a <= patternChar && patternChar <= z) {
                if (patternChar != stringChar) {
                    return false;
                }
                j--;
            }
            // '.'
            else if (patternChar == dot) {
                j--;
            }
            i--;
        }
        // cleanup ignorable pattern
        while (i >= 0) {
            if (p.charAt(i) == dot) {
                i--;
                continue;
            } else if (p.charAt(i) == star) {
                i--;
                i--;
                continue;
            }
        }
        if (i >= 0 && (p.charAt(i) >= a && p.charAt(i) <= z)) {
            return false;
        }
        if (j >= 0) {
            return false;
        }
        return true;
    }

    public static boolean isMatchWithstack(String s, String p) {
        char a = 'a';
        char z = 'z';
        char dot = '.';
        char star = '*';
        Stack<String> stack = new Stack<String>();
        int i = p.length() - 1;
        String basicpattern = "";
        while (i >= 0) {
            int index = i;
            if (a <= p.charAt(i) && p.charAt(i) <= z) {
                while (i >= 0 && a <= p.charAt(i) && p.charAt(i) <= z) {
                    i--;
                    continue;
                }
                basicpattern = p.substring(i + 1, index + 1) + basicpattern;
            } else if (p.charAt(i) == star) {
                i--;
                i--;
            } else {
                i--;
                basicpattern = p.substring(i + 1, index + 1) + basicpattern;
            }
            stack.add(p.substring(i + 1, index + 1));
            
        }
        if (basicpattern.length() == s.length()) {
            for (int j = 0; j < s.length(); j++) {
                if (basicpattern.charAt(j) == dot || s.charAt(j) == basicpattern.charAt(j)) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
        int starMatches = s.length() - basicpattern.length();
        if(starMatches<0 || stack.isEmpty())
        {
            return false;
        }
        i = 0;
        while (!stack.isEmpty() && starMatches>0) {
            String subp = stack.pop();
            if (subp.indexOf('*') > -1) {
                
                while (starMatches > 0) {
                    if(!stack.isEmpty())
                    {
                        String nextPattern = stack.peek();
                        int nextlength = nextPattern.length();
                        if(!nextPattern.equals(s.substring(i, i + nextlength)))
                        {
                            break;
                        }
                        
                    }
                    
                    if (subp.charAt(0) == dot || subp.charAt(0) == s.charAt(i)){
                        i++;
                        starMatches--;
                    }
                }
            } else if (subp.charAt(0) == dot) {
                i++;
            } else if (subp.equals(s.substring(i, i + subp.length() - 1))) {
                i = i + subp.length();
            } else {
                return false;
            }
        }
        if(i<s.length())
        {
            return false;
        }

        return true;
    }
//https://leetcode.com/problems/regular-expression-matching/solutions/3151728/brute-force-tle-solution/
    public static boolean isMatch3(int i, String s, int j, String p) { 
        int sn = s.length(), pn = p.length();
        if(j==pn) { 
            return i==sn;    
        }
        char pj = p.charAt(j);
        if(j+1<pn && p.charAt(j+1)=='*') {
            if(isMatch3(i,s,j+2,p)) {
                return true;
            }
            while(i<sn && (pj == '.'||pj==s.charAt(i))) {
                if(isMatch3(++i,s,j+2,p)) {
                    return true;
                }
            }
        } else if(i<sn && (s.charAt(i) == pj ||    pj=='.')) {              
            return isMatch3(i+1, s, j+1, p);
        }
        return false;
    }
}
