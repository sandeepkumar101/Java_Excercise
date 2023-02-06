package Common;
import java.util.*;

class TreeNode3 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode3(int x) {
        val = x;
    }
};

class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode1 root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        // TODO: Write your code here
        findPath(root, sum, subList, allPaths);
        return allPaths;
    }

    public static void findPath(TreeNode1 root, int sum, List<Integer> subList, List<List<Integer>> fullList) {
        if (root == null) {
            return;
        }
        subList.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {

            fullList.add(new ArrayList<>(subList));
        } else {
            findPath(root.left, sum - root.val, subList, fullList);

            findPath(root.right, sum - root.val, subList, fullList);
        }
        subList.remove(subList.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(4);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}