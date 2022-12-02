package Common;

class TreeNode7 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode7(int x) {
        val = x;
    }
};

class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode1 root) {
        // TODO: Write your code here

        return recursiveCall(root, 0);
    }

    public static int recursiveCall1(TreeNode1 root, int total, int currentSum) {
        if (root == null) {
            return total;
        }
        int currentVal = root.val;
        currentSum = currentSum * 10 + currentVal;
        if (root.left == null && root.right == null) {
            return total + currentSum;
        }
        return recursiveCall1(root.left, total, currentSum) + recursiveCall1(root.right, total, currentSum);
    }

    public static int recursiveCall(TreeNode1 root, int total) {
        if (root == null) {
            return 0;
        }
        int currentVal = root.val;
        total = total * 10 + currentVal;
        if (root.left == null && root.right == null) {
            return total;
        }
        return recursiveCall(root.left, total) + recursiveCall(root.right, total);
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(0);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(1);
        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
