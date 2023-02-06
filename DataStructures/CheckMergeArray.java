package DataStructures;

/**
 * given two sorted arrays, you have to implement the int[] 
 * mergeArrays(int[] arr1, int[] arr2) method, 
 * which returns an array consisting of all elements of both arrays in a sorted way.
 */
public class CheckMergeArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5};  
        int[] arr2 = {2, 6, 7, 8};
        CheckMergeArray cma= new CheckMergeArray();
        System.out.println(cma.mergeArrays(arr1,arr2));
    }

    int[] mergeArrays(int[] arr1, int[] arr2){
        int[] mergeArray = new int[arr1.length+arr2.length];
        int i =0,j=0;
        while(i<arr1.length || j < arr2.length)
        {
            if(i<arr1.length && arr1[i]<=arr2[j])
            {
                mergeArray[i+j] = arr1[i];
                i++;
            }
            else if(j<arr2.length)
            {
                mergeArray[i+j] = arr2[j];
                j++;
            }
        }
        return mergeArray;
    }

    int[] mergeArrays1(int[] arr1, int[] arr2){
        int[] mergeArray = new int[arr1.length+arr2.length];
        int i =0,j=0,k=0;
        while(i<arr1.length && j < arr2.length)
        {
            if(arr1[i]<=arr2[j])
            {
                mergeArray[k++] = arr1[i];
                i++;
            }
            else
            {
                mergeArray[k++] = arr2[j];
                j++;
            }
        }
        while(i<arr1.length)
        {
            mergeArray[k++] = arr1[i];
            i++;
        }
        while(j<arr2.length)
        {
            mergeArray[k++] = arr2[j];
            j++;
        }
        return mergeArray;
    }
}
