package common;

import java.util.LinkedList;

/**
 * Suppose you're given a binary tree represented as an array. For example, [3,6,2,9,-1,10] represents the following binary tree (where -1 is a non-existent node):

enter image description here

Write a function that determines whether the left or right branch of the tree is larger. The size of each branch is the sum of the node values. The function should return the string "Right" if the right side is larger and "Left" if the left side is larger. If the tree has 0 nodes or if the size of the branches are equal, return the empty string.

Example Input:

[3,6,2,9,-1,10] 
Example Output:

Left
 */
public class BinaryTreeLargerBranch {
    public static String solution(long[] arr) {
        // Type your solution here
        long[] sum = new long[arr.length];
        long left = 0l;
        long right = 0l;
        LinkedList ll = new LinkedList<>();
        ll.add(arr[0]);
        for(int i = 1; i<arr.length ;i++)
        {
            if(ll.isEmpty())
            {
                
            }
        }
        return null;
    }
}
