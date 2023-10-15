package common;
public class ValidPalindrome {
    public static void main(String[] args) {
        String s =  ".,";//"A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s.toLowerCase()));
    }

    public static boolean isPalindrome1(String s) {
        s = s.toLowerCase();
        if (s == null || s.length() == 0)
            return true;
        if (s.length() == 1)
            return true;
        int left = 0;
        int right = s.length() - 1;
        char[] c = s.toCharArray();
        for (; left < right; left++, right--) {
            System.out.println("left:" + left + ", right:" + right);
            System.out.println("c[left]:" + c[left] + ", c[right]:" + c[right]);

            while (left < s.length() && !Character.isLetterOrDigit(c[left]))
                left++;
            while (right >= 0 && !Character.isLetterOrDigit(c[right]))
                right--;

            if (left > s.length() || right >= 0) {
                System.out.println("c[left]:" + c[left] + ", c[right]:" + c[right]);

                if (s.charAt(left) != s.charAt(right))
                    return false;

            }

        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        if (s == null || s.length() == 0)
            return true;
        if (s.length() == 1)
            return true;
        int left = 0;
        int right = s.length() - 1;
        char[] c = s.toCharArray();
        for (; left < right; left++, right--) {
            System.out.println("left:" + left + ", right:" + right);
            System.out.println("c[left]:" + c[left] + ", c[right]:" + c[right]);
            if (s.charAt(left) != s.charAt(right))
                return false;
        }
        return true;
    }

    public static boolean isValidPalindrome(String s)
    {
        if(s == null || s.isEmpty())
        {
            return false;
        }
        int left  = 0;
        int right = s.length() -1;
        //Iterate wusing tow pointer
        boolean isPalindrome = false;
        while(left<=right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            else
            {
                right--;
                left++;
            }
        }
        return isPalindrome;

    }
}
