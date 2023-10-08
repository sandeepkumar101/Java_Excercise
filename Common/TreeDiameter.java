package common;
class TreeNode8 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode8(int x) {
        val = x;
    }
};

class TreeDiameter {
    static int diameter = 0;

    public static int findDiameter(TreeNode1 root) {
        // TODO: Write your code here
        recursiceCall1(root);
        return diameter;
    }

    public static int recursiceCall(TreeNode1 root, int depth, int maxDepth, boolean isLeft) {
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

    public static int recursiceCall1(TreeNode1 root) {
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
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.right = new TreeNode1(4);
        root.right.left = new TreeNode1(5);
        root.right.right = new TreeNode1(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.right = null;
        root.right.left.left = new TreeNode1(7);
        root.right.left.right = new TreeNode1(8);
        root.right.right.left = new TreeNode1(9);
        root.right.left.right.left = new TreeNode1(10);
        root.right.right.left.left = new TreeNode1(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
