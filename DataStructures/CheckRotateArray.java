package DataStructures;

public class CheckRotateArray {

    public static void main(String args[]) {

        int[] arr = {3, 6, 1, 8, 4, 2};
    
        System.out.print("Array before rotation: ");
        for(int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
    
        rotateArrayBackword(arr);
    
        System.out.print("Array after rotation: ");
        for(int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
 
        rotateArrayforward(arr);
    
        System.out.print("Array after rotation: ");
        for(int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
      }

    public static void rotateArrayforward(int[] arr){
        int temp = arr[0];
        arr[0]=arr[arr.length-1];
        
        for(int i=1; i< arr.length;i++)
        {
            int swap = temp;
            temp = arr[i];
            arr[i] = swap;
        }
        // Write - Your - Code    
    }

    public static void rotateArrayBackword(int[] arr) {

        //Store Last Element of Array.
        //Start from last and Right Shift the Array by one.
        //Store the last element saved to be the first element of array.
        int lastElement = arr[arr.length - 1];
    
        for (int i = arr.length - 1; i > 0; i--) {
    
          arr[i] = arr[i - 1];
        }
    
        arr[0] = lastElement;
      }
}
