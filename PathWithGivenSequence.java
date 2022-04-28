import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        // TODO: Write your code here
        return recursiveCall(root, sequence, 0);
    }

    public static boolean recursiveCall(TreeNode node, int[] sequence, int level) {
        if (node == null)
            return false;

        if (node.val != sequence[level]) {
            return false;
        }
        if (node.val == sequence[level] && level+1 == sequence.length) {
            return true;
        }
        return recursiveCall(node.left, sequence, level + 1) || recursiveCall(node.right, sequence, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
