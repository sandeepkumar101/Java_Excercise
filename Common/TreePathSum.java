package Common;

class TreeNode9 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode9(int x) {
        val = x;
    }
};

class TreePathSum {
    public static boolean hasPath(TreeNode1 root, int sum) {
        // TODO: Write your code here
        if (root == null)
            return false;

        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(9);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    }
}
