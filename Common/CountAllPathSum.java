package Common;
import java.util.*;

class TreeNode2 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode2(int x) {
        val = x;
    }
};

class CountAllPathSum {
    public static int countPaths(TreeNode1 root, int S) {
        // TODO: Write your code here
        List<Integer> pathList = new ArrayList<>();
        return recursiveCall(root, S, 0, pathList);
    }

    public static int recursiveCall(TreeNode1 root, int S, int pathSum, List<Integer> pathList) {
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
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(4);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        root.right.right.left = new TreeNode1(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
