package common;

import java.util.Stack;
/**
 * Example

For inputString = "(bar)", the output should be
solution(inputString) = "rab";
For inputString = "foo(bar)baz", the output should be
solution(inputString) = "foorabbaz";
For inputString = "foo(bar)baz(blim)", the output should be
solution(inputString) = "foorabbazmilb";
For inputString = "foo(bar(baz))blim", the output should be
solution(inputString) = "foobazrabblim".
Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".

 */
public class ReverStringInParentheses {
    String solution(String inputString) {

        Stack<Integer> s = new Stack<>();
        char[] chararray = inputString.toCharArray();
        for(int i = 0; i < inputString.length(); i++)
        {
            if(inputString.charAt(i) == '(')
            {
                s.add(i);
            }
            else if(inputString.charAt(i) == ')'){
                int  end = i-1;
                int start = s.pop()+1;
                while(start < end)
                {
                    char temp = chararray[start];
                    chararray[start]= chararray[end];
                    chararray[end] = temp;
                    start++;
                    end--;
                }
                
            }
            
        }
        StringBuilder sb = new StringBuilder();
            for(char c:chararray)
            {
                if(c != '(' && c != ')' )
                {
                    sb.append(c);
                }
            }
            return sb.toString();
        
        
        
        
        }
}
