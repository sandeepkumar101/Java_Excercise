package Common;

public class FindLargerNumber {
    public static void main(String[] args) {
        
    }
    public static long solution(long[] numbers) {
        // Type your solution here
        if(numbers == null || numbers.length==0)
        {
            return 0;
        }
        long max = Integer.MIN_VALUE;
        for(long l : numbers)
        {
            max = Math.max(max, l);
        }
        return max;
    }
}
