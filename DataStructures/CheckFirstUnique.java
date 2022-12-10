package DataStructures;

/**
 * Problem Statement#
In this problem, you have to implement the int findFirstUnique(int[] arr) 
method that will look for a first unique integer, 
which appears only once in the whole array. 
The function returns -1 if no unique number is found.
 */

public class CheckFirstUnique {
    public static void main(String args[]) {

        int[] arr = { 4,5,1,2,0,4};
    
        System.out.print("Array : ");
        for(int i = 0; i < arr.length; i++)
          System.out.print(arr[i] + " ");
        System.out.println();
    
        int min = findFirstUnique(arr);
        System.out.println("Unique in the Array: " + min);
    
      }

    public static int findFirstUnique(int[] arr) 
    {
     sort(arr, 0, arr.length-1);   
    
     int index = 0;
     for(int i =1; i < arr.length;i++,index++)
     {
        if(arr[i] != arr[index] && arr[index]>0)
        {
            return arr[index];
        }
        while(arr[i]== arr[index])
        {
            index++;
            i++;
        }
     }
      // write your code here
      return -1;
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
   }
