package DataStructures;

/**
 * Problem Statement
In this problem, you have to implement the int findMinimum(int[] arr) method, 
which will traverse the whole array and find the smallest number in the array.
 */
public class CheckMinimum {
    public static void main(String args[]) {

        int[] arr = { 9, 2, 3, 6};
    
        System.out.print("Array : ");
        for(int i = 0; i < arr.length; i++)
          System.out.print(arr[i] + " ");
        System.out.println();
    
        int min = findMinimum(arr);
        System.out.println("Minimum in the Array: " + min);
    
      }

    public static int findMinimumOld(int[] arr) {
      // Write your code here
      int min = arr[0];
      for(int i : arr)
      {
        if(i<min)
        {
            min = i;
        }
      }
      return min;      
    }

    public static int partition(int[] arr, int low, int high)
    {
        int pivate = arr[high];
        int index = low -1;
        for(int i = low; i < high; i++){
            if(arr[i]<= arr[high])
            {
                index++;
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        index++;
        int temp = arr[index];
        arr[index] = arr[high];
        arr[high] = temp;
        return index;
    }

    public static void sort(int[] arr, int low, int high)
    {
        if(low<high)
        {
            int pivate = partition(arr, low, high);
            sort(arr, low, pivate-1);
            sort(arr, pivate+1, high);
        }
    }

    public static int findMinimum(int[] arr) {
        sort(arr, 0, arr.length-1);
        return arr[0];
    }

  }
