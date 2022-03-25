import java.util.Arrays;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "bba", t = "ab";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        //String sl = s.toLowerCase();
        //String tl = t.toLowerCase();
        int li = -1;
        int ri = -1;
        boolean[] bsarray = new boolean[128];
        int[] bsiarray = new int[128];
        boolean[] btarray = new boolean[128];
        
        if(s.length()<t.length())
        {
            return "";
        }

        if(s.equals(t))
        {
            return t;
        }

        for (int i = 0; i < t.length(); i++) {
            btarray[t.charAt(i)] = true;
        }

        int left = 0;
        int right = 0;
       // if (btarray[sl.charAt(left)]) {
       //     bsiarray[sl.charAt(left)]++;
       //     bsarray[sl.charAt(left)] = bsiarray[sl.charAt(left)] > 0 ? true : false;

      //  }
        while (left <= right && right < s.length()) {
            if (!btarray[s.charAt(left)]) {
                while (left < s.length()) {
                    if (btarray[s.charAt(left)]) {
                        break;
                    }
                    left++;
                }
            }
            if(left<s.length())
            {
            if (right < left) {
                right = left;
            }

            if (btarray[s.charAt(right)]) {
                bsiarray[s.charAt(right)]++;
                bsarray[s.charAt(right)] = bsiarray[s.charAt(right)] > 0 ? true : false;
            }

            if (Arrays.equals(bsarray, btarray)) {
                if (ri - li == 0 || ri - li > right - left) {
                    ri = right;
                    li = left;
                }
                bsiarray[s.charAt(left)]--;

                bsarray[s.charAt(left)] = bsiarray[s.charAt(left)] > 0 ? true : false;
                left++;

            }
            if(right+1<s.length())
            right++;
        }
        }
        return li+ri>=0?s.substring(li, ri + 1):"";
    }

}
