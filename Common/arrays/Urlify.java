package common.arrays;
public class Urlify{
    public static void main(String[] arg){
        String str = "b ar  ";
        System.out.println(urlify(str, 4));

    }
    public static String urlify(String str, int trueLength)
    {
        char[] charArray = str.toCharArray();
        char space = ' ';
        int spaceCounter = 0;
        for(int i = 0; i < trueLength; i++){
                if(str.charAt(i) == space)
                spaceCounter++;
            }
        int endPointer = spaceCounter * 2 + trueLength;
        for(int i = trueLength-1; i>=0; i--)
        {
            if(str.charAt(i) == space)
            {
                charArray[--endPointer] = '0';
                charArray[--endPointer] = '2';
                charArray[--endPointer] = '%';
            }
            else
            {
                charArray[--endPointer] = str.charAt(i);
            }
        }
        return String.copyValueOf(charArray);
    }
}