package Common;

class TreeNode5 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode5(int x) {
        val = x;
    }
};

class PathWithGivenSequence {
    public static boolean findPath(TreeNode1 root, int[] sequence) {
        // TODO: Write your code here
        return recursiveCall(root, sequence, 0);
    }

    public static boolean recursiveCall(TreeNode1 node, int[] sequence, int level) {
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
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(0);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(1);
        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
