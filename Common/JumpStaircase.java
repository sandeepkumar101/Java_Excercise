package common;

import java.util.Arrays;
//Hired Assessments
/**
 * There are 4 different ways you can jump up to the top of the stairs:
jump 1 stair, jump 1 stair, jump 1 stair
jump 2 stairs at once, jump 1 stair
jump 1 stair, jump 2 stairs at once
jump 3 stairs at once
 */
public class JumpStaircase{
    public static void main(String[] args) {
        System.out.println(solution(5));
    }
    public static int solution(int n)
    {
        return jump(n,1,0);
        
    }
    static int jump(int stairs, int jump, int total)
    {
        if(stairs>0 && jump>0)
        {
        if(stairs>jump )
        {
            total++;
            stairs = stairs- jump;
            total = jump(stairs, jump, total);
            total = jump(stairs, jump+1, total);
            total = jump(stairs, jump+2, total);
        }
        else{
            jump--;
            total = jump(stairs, jump, total);
        }
    }
        return total;
    }
}