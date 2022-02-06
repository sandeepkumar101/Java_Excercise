import javax.lang.model.util.ElementScanner6;

public class ValidPalindromeII {
    public static void main(String[] args) {
        String s = "acxcybycxcxa";// "A
        System.out.println(validPalindrome(s.toLowerCase()));
    }

    public static boolean validPalindrome1(String s) {
        s = s.toLowerCase();
        if (s == null || s.length() == 0)
            return true;
        if (s.length() == 1)
            return true;
        int left = 0;
        int right = s.length() - 1;
        char[] c = s.toCharArray();
        int unmatchlimit = 1;
        for (; left < right;) {
            // System.out.println("left:" + left + ", right:" + right);
            // System.out.println("c[left]:" + c[left] + ", c[right]:" + c[right]);

            // while (left < s.length() && !Character.isLetterOrDigit(c[left]))
            // left++;
            // while (right >= 0 && !Character.isLetterOrDigit(c[right]))
            // right--;

            if (left > s.length() || right >= 0) {
                // System.out.println("c[left]:" + c[left] + ", c[right]:" + c[right]);

                if (s.charAt(left) != s.charAt(right)) {
                    if (unmatchlimit > 0 && left + 1 <= right && s.charAt(left + 1) == s.charAt(right)) {
                        if (left + 2 < s.length() && right - 1 >= 0 && left + 2 <= right - 1) {
                            if (s.charAt(left + 2) == s.charAt(right - 1)) {
                                // System.out.println("Removing -left:" + left + ", c[left]:" + c[left]);
                                left++;
                                unmatchlimit--;
                                continue;
                            }
                        } else {
                            // System.out.println("Removing -left:" + left + ", c[left]:" + c[left]);
                            left++;
                            unmatchlimit--;
                            continue;
                        }

                    }
                    if (unmatchlimit > 0 && right - 1 >= left && s.charAt(left) == s.charAt(right - 1)) {
                        if (right - 2 >= 0 && left + 1 <= s.length() && right - 2 <= left + 1) {
                            if (s.charAt(right - 2) == s.charAt(left + 1)) {
                                // System.out.println("Removing -right:" + right + ", c[right]:" + c[right]);
                                right--;
                                unmatchlimit--;
                                continue;
                            }
                        } else {
                            // System.out.println("Removing -right:" + right + ", c[right]:" + c[right]);
                            right--;
                            unmatchlimit--;
                            continue;
                        }
                    }

                    return false;
                } else {
                    left++;
                    right--;
                }

            }

        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }

            return validPalindromeHelper(left + 1, right, s) || validPalindromeHelper(left, right - 1, s);
        }

        return true;
    }

    public static boolean validPalindromeHelper(int left, int right, String s) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
