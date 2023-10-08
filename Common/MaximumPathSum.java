package common;
class TreeNode6 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
  
    TreeNode6(int x) {
      val = x;
    }
  };
  
  class MaximumPathSum {
    static int maxPathSum = 0;
    public static int findMaximumPathSum(TreeNode1 root) {
      // TODO: Write your code here
      recursiveCall(root);
      return maxPathSum;
    }

    public static int recursiveCall(TreeNode1 root){
        if(root == null)
        {
            return 0;
        }
        int leftSum = recursiveCall(root.left);
        int rightSum = recursiveCall(root.right);
        maxPathSum  =Math.max(maxPathSum,leftSum+rightSum+root.val);

        return Math.max(leftSum, rightSum)+root.val;

    }
  
    public static void main(String[] args) {
      TreeNode1 root = new TreeNode1(1);
      root.left = new TreeNode1(2);
      root.right = new TreeNode1(3);
      System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
      
      root.left.left = new TreeNode1(1);
      root.left.right = new TreeNode1(3);
      root.right.left = new TreeNode1(5);
      root.right.right = new TreeNode1(6);
      root.right.left.left = new TreeNode1(7);
      root.right.left.right = new TreeNode1(8);
      root.right.right.left = new TreeNode1(9);
      System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
      
      root = new TreeNode1(-1);
      root.left = new TreeNode1(-3);
      System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
  }