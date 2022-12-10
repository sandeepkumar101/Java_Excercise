package Common;

import java.util.Stack;
//Hired Assessments
public class CompleteBrackets {
    public static void main(String[] args) {
        String angles = "<>><>"; // "><<><";
        // Expect "<><<><>>"
        System.out.println(solution2(angles));
    }

    static char angleOpen = '<';
    static char angleClose = '>';

    public static String solution(String angles) {
        // Type your solution here
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : angles.toCharArray()) {
            if (c == angleClose) {
                if (stack.size() == 0) {
                    sb.append(completeBraket(c));
                    sb.append(stack.pop().charValue()).append(c);
                } else {

                }

            } else {
                stack.add(c);
            }
        }
        while (!stack.empty()) {
            sb.append(completeBraket(stack.pop().charValue()));
        }
        return sb.toString();
    }

    public static String completeBraket(char c) {
        if (c == angleOpen) {

            return String.valueOf(c) + String.valueOf(angleClose);
        } else {
            return String.valueOf(angleOpen) + String.valueOf(c);
        }
    }

    public static String solution2(String angles) {
        int openCount = 0;
        int closeCount = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : angles.toCharArray()) {
            if (c == angleClose) {
                if (openCount == 0) {
                    closeCount++;
                } else {
                    openCount--;
                }
            } else {
                openCount++;
            }
        }
        while (closeCount > 0) {
            sb.append(angleOpen);
            closeCount--;
        }
        sb.append(angles);
        openCount = 0;
        closeCount = 0;
        angles = sb.toString();
        for (int i = angles.length() - 1; i >= 0; i--) {
            char c = angles.charAt(i);
            if (c == angleOpen) {
                if (closeCount == 0) {
                    openCount++;
                } else
                    closeCount--;
            } else {
                closeCount++;
            }
        }

        while (openCount > 0) {
            sb.append(angleClose);
            openCount--;
        }
        return sb.toString();
    }
}
