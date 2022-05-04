package Common;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class TreeDiameter {
    static int diameter = 0;

    public static int findDiameter(TreeNode root) {
        // TODO: Write your code here
        recursiceCall1(root);
        return diameter;
    }

    public static int recursiceCall(TreeNode root, int depth, int maxDepth, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (isLeft || root.left == null && root.right == null) {
            System.out.println("Added-" + root.val);
            depth++;
        } else {
            System.out.println("Set to One-" + root.val);
            depth = 1;

        }
        maxDepth = Math.max(maxDepth, depth);
        if (isLeft && root.left == null) {
            return maxDepth;
        }

        if (!isLeft && root.right == null) {
            return maxDepth;
        }

        return recursiceCall(root.left, depth, maxDepth, true) + recursiceCall(root.right, depth, maxDepth, false);

    }

    public static int recursiceCall1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = recursiceCall1(root.left);
        int rightDiameter = recursiceCall1(root.right);
        if (leftDiameter != 0 && rightDiameter != 0) {
            diameter = Math.max(diameter, leftDiameter + rightDiameter + 1);
        }

        return Math.max(leftDiameter, rightDiameter) + 1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.right = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
