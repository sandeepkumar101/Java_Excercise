package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In this problem, you have to implement the int [] 
 * removeEven(int[] arr) method, which removes all 
 * the even elements from the array and returns back updated array.
 * 
 */
public class CheckRemoveEven {

    public static void main(String[] args) {
		int[] arr = {1, 2, 4, 5, 10, 6, 3};
		System.out.println(Arrays.toString(removeEven1(arr)));
	}
    public static int[] removeEven(int[] arr) {
		int oddCount = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i]%2 != 0)
			{
				oddCount++;
			}
		}
		int[] oddArr = new int[oddCount];
		int count = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i]%2 != 0)
			{
				oddArr[count] = arr[i];
				count++;
			}
		}

		// Write - Your - Code- Here
		return oddArr; // change this and return the correct result array
	}

	public static int[] removeEven1(int[] arr)
	{
		if(arr == null || arr.length ==0)
		{
			return null;
		}
		List<Integer> oddList = new ArrayList();

		for(int i : arr)
		{
			if(i%2!=0)
			{
				oddList.add(i);
			}
		}

		return oddList.stream().mapToInt(i -> i).toArray();
		
	}
}
