package twopointer;

public class ReverseWords {
    public static void main(String[] args) {
        String str = "this is  hello  my  word I would like to learn it. ";
        System.out.println(strClean(str));
        System.out.println(reverseWords(str));
        
    }
    public static String reverseWords(String sentence) {
        //sentence = strClean(sentence);
        sentence = sentence.replaceAll("\\s+", " ").trim();
        char[] words = sentence.toCharArray();
        reverseStr(words, 0, words.length-1);
        char space = ' ';
        int start = 0;
        int end  = 0;
        int current = 0;
        while(current<words.length)
        {
            if(words[current] == space ){
                end = current;
                reverseStr(words, start, end-1);
                start = current+1;
            }
            if(current == words.length-1){
                end = current;
                reverseStr(words, start, end);
            }
            current++;
        }
    
        // Replace this placeholder return statement with your code
        return String.copyValueOf(words);
    }
    public static void reverseStr(char[] str , int start, int end){
        while(start<end){
            char c = str[start];
            str[start] = str[end];
            str[end] = c;
            start++;
            end--;
        }
    }

    public static String strClean(String str){
        StringBuilder sb = new StringBuilder();
        char preChar = ' ';
        boolean doAppend = false;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(preChar != c || preChar != ' '){
                if(doAppend)
                    sb.append(preChar);
                doAppend = true;    
                preChar = c;
            }
        }
        if(preChar != ' '){
            sb.append(preChar);
        }
        return sb.toString();
    }
}
