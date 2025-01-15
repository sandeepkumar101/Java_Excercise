package twopointer;

import java.util.HashMap;
import java.util.Map;

public class Strobogrammatic {
public static void main(String[] args) {
    String[] values = {"101","808", "99","9","69","96","121","234"};
    for (String value : values)
    {
        System.out.println(isStrobogrammatic(value));
    }
    
}   
 public static boolean isStrobogrammatic (String num) 
    {
      Map<Character, Character> dictionary = new HashMap<>();
      dictionary.put('6','9');
      dictionary.put('9','6');
      int left = 0;
      int right  = num.length()-1;
      while(left <= right)
      {
        if(num.charAt(left) != num.charAt(right) 
        && dictionary.getOrDefault(num.charAt(left),'a') != num.charAt(right))
        {
          return false;  
        }
        left++;
        right--;
      }
      // Replace this placeholder return statement with your code
        return true;
    }

}
