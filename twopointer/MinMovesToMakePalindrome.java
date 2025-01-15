package twopointer;

public class MinMovesToMakePalindrome {
    public static void main(String[] args){
        String[] s = {"abcacb","ccxx","arcacer","w","ooooooo","eggeekgbbeg"};
        for(String value : s)
        System.out.println(minMovesToMakePalindrome(value));  // Output: 1
    }
    public static int minMovesToMakePalindrome(String s) {
        char[] c = s.toCharArray();
        int move = 0;
        int left = 0;
        int right = s.length() -1;
        while(left < right){
            if(c[left] == c[right])
            {
                left++;
                right--;
            }
            else{
                int innerright = right-1;
                while(left<innerright){
                    if(c[left]== c[innerright]){
                        char temp = c[right];
                        c[right] = c[innerright];
                        c[innerright] = temp;
                        move++;
                        right--;
                        left++;
                        break;
                    }
                    innerright--;
                }
                if(left == innerright){
                    int center = (left + right) / 2;
                    char temp = c[left];
                    c[left] = c[left+center];
                    c[left+center] = temp;
                    move++;
                }
            }
        }
        // Replace this placeholder return statement with your code
        return move;
    }

}
