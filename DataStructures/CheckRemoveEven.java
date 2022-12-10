package DataStructures;

/**
 * In this problem, you have to implement the int [] 
 * removeEven(int[] arr) method, which removes all 
 * the even elements from the array and returns back updated array.
 * 
 */
public class CheckRemoveEven {

    
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
}
