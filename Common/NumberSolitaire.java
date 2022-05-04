package Common;
import java.util.Random;

public class NumberSolitaire {
    
    public static void main(String[] args) {
        int[] A = {1, -2, 0, 9, -1, -2};
        NumberSolitaire n = new NumberSolitaire();
        System.out.println(n.solution(A));
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        Random r = new Random();
        
        return recursiveCall(A,0,r,0);
    }
    public int recursiveCall(int[] A, int index,Random r,int sum)
    {
        if(index == A.length-1)
        {
            return sum+A[index];
        }
        int k = r.nextInt(6)+1;
        while(index + k >= A.length)
        {
            k = r.nextInt(6)+1;
        }

        return recursiveCall(A,index+k,r,sum+A[index+k]);
    } 
}
