package twopointer;
import java.util.*;

public class ValidPalindrome{
    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("3456543"));
    }
    public static boolean isPalindrome(String s) {
       int startIndex = 0;
       int endIndex = s.length()-1;
        while(startIndex <= endIndex)
        {
            if(s.charAt(startIndex) == s.charAt(endIndex))
            {
                startIndex++;
                endIndex--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}