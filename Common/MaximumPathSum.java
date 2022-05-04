package Common;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  
    TreeNode(int x) {
      val = x;
    }
  };
  
  class MaximumPathSum {
    static int maxPathSum = 0;
    public static int findMaximumPathSum(TreeNode root) {
      // TODO: Write your code here
      recursiveCall(root);
      return maxPathSum;
    }

    public static int recursiveCall(TreeNode root){
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
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
      
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      root.right.left = new TreeNode(5);
      root.right.right = new TreeNode(6);
      root.right.left.left = new TreeNode(7);
      root.right.left.right = new TreeNode(8);
      root.right.right.left = new TreeNode(9);
      System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
      
      root = new TreeNode(-1);
      root.left = new TreeNode(-3);
      System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
  }