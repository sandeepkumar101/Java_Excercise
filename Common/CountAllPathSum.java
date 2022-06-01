package Common;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        // TODO: Write your code here
        List<Integer> pathList = new ArrayList<>();
        return recursiveCall(root, S, 0, pathList);
    }

    public static int recursiveCall(TreeNode root, int S, int pathSum, List<Integer> pathList) {
        if (root == null) {
            return 0;
        }
        pathSum = pathSum + root.val;
        pathList.add(root.val);
        while (pathSum > S) {
            int val = pathList.remove(0);
            pathSum -= val;
        }
        if (pathSum == S) {
            System.out.println(pathList);
            return 1;
        }
        return recursiveCall(root.left, S, pathSum, pathList) + recursiveCall(root.right, S, pathSum, pathList);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
