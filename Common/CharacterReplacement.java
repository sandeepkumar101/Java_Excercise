package Common;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static void main(String[] args) {

        System.out.println(findLength("aabccbb", 2));
    }
    public static int findLength(String str, int k) {
        // TODO: Write your code here
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxCharCount = 0;
        int longsetStrCount = 0;
        for(int i = 0; i < str.length(); i++)
        {
          map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
          maxCharCount = Math.max(maxCharCount,map.get(str.charAt(i)));
          while((i-start+1)-maxCharCount>k && start<i)
          {
            map.put(str.charAt(start),map.get(str.charAt(start))-1);
            if(map.getOrDefault(str.charAt(start),0)==0)
            {
              map.remove(str.charAt(start));
            }
            start++;
          }
          longsetStrCount = Math.max(longsetStrCount,i-start+1);
        }
    
        return longsetStrCount;
      }

      public static boolean findPermutation(String str, String pattern) {
    // TODO: Write your code here
    int[] patternArray = {26};
    int[] strArray = {26};

    for(int i = 0 ; i < pattern.length(); i++)
    {
      patternArray[pattern.charAt(i)-'a']++;
      strArray[str.charAt(i)-'a']++;
    }
    int start = 0;
    int count = 0;

    if(Arrays.equals(patternArray,strArray))
      return true;

    for(int i = pattern.length(); i < str.length(); i++,start++)
    {
      

      strArray[str.charAt(i)-'a']++;
      strArray[str.charAt(start)-'a']--;

      if(Arrays.equals(patternArray,strArray))
      return true;

    }
    return Arrays.equals(patternArray,strArray);
  }
}
