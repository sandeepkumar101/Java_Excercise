import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare2("xywrrmp", "xywrrmu#p"));
    }

    public static boolean backspaceCompare(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        char backspacechar = '#';
        int i = sa.length - 1;
        int j = ta.length - 1;
        int ix = 0;
        int jx = 0;
        StringBuffer sb = new StringBuffer();
        StringBuffer tb = new StringBuffer();

        while (i >= 0) {
            if (sa[i] == backspacechar) {
                ix++;
                i--;
            } else if (sa[i] != backspacechar) {
                if (ix > 0) {
                    ix--;
                } else {
                    sb.append(sa[i]);
                }
                i--;

            }
        }
        while (j >= 0) {
            if (ta[j] == backspacechar) {
                jx++;
                j--;
            } else if (ta[j] != backspacechar) {
                if (jx > 0) {
                    jx--;
                } else {
                    tb.append(ta[j]);
                }
                j--;
            }
        }
        if (sb.toString().equals(tb.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean backspaceCompare1(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(char ch : s.toCharArray()) {
        	if(ch == '#'){
                if(st1.size() > 0)
                    st1.pop();
            }else
        		st1.push(ch);
        }
        for(char ch : t.toCharArray()) {
            if(ch == '#'){
                if(st2.size() > 0)
                    st2.pop();
            }else
        		st2.push(ch);
        }
        if(st1.size() != st2.size())
        	return false;
        while(st1.size() > 0) {
        	char ch1 = st1.pop();
        	char ch2 = st2.pop();
        	if(ch1 != ch2)
        		return false;
        }
        return true;
    }

    public static boolean backspaceCompare2(String s, String t) {
        if (s.length() == 1 && t.length() == 1) return s.equals(t);
        return cleansedString(t).equals(cleansedString(s));
    }
    
    private static Stack<Character> cleansedString(String str) {
        Stack<Character> stackStr = new Stack<>();
        for (var ch : str.toCharArray()) {
            if (ch == '#') {
                if (!stackStr.isEmpty()) stackStr.pop();
            } else {
                stackStr.push(ch);
            }
        }
        return stackStr;
    }
}
