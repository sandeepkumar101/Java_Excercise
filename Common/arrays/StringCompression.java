package common.arrays;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("thisssfsdfdfiiidsdi"));
    }

    public static String compress(String str)
    {
        StringBuilder compressed = new StringBuilder();
        int counter = 1;
        compressed.append(str.charAt(0));
        for(int i = 1; i< str.length();i++)
        {
            if(str.charAt(i) == str.charAt(i-1))
            {
                counter++;
            }
            else{
                compressed.append((counter>1?counter:"")+""+str.charAt(i));
                counter = 1;
            }
        }
        return compressed.toString();
    }

}
