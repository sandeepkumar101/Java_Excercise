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

class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // TODO: Write your code here
        Queue<TreeNode> travelQueue = new LinkedList<>();
        travelQueue.offer(root);

        while (!travelQueue.isEmpty()) {

            int level = travelQueue.size();

            List<Integer> list = new ArrayList<>(level);
            for (int i = 0; i < level; i++) {
                TreeNode node = travelQueue.poll();
                list.add(node.val);

                // Add Left
                if (node.left != null)
                    travelQueue.add(node.left);

                // Add Right
                if (node.right != null)
                    travelQueue.add(node.right);

            }
            result.add(list);

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
};

class MinimumBinaryTreeDepth {
    public int findDepth(TreeNode root) {
        // TODO: Write your code here
        Queue<TreeNode> travelQueue = new LinkedList<>();
        travelQueue.offer(root);
        int depth = 0;
        while (!travelQueue.isEmpty()) {
            int level = travelQueue.size();
            depth++;
            for (int i = 0; i < level; i++) {
                TreeNode node = travelQueue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null)
                    travelQueue.add(node.left);
                if (node.right != null)
                    travelQueue.add(node.right);
            }
        }
        return -1;
    };
}

class LevelOrderSuccessor {
    public TreeNode findSuccessor(TreeNode root, int key) {
        Queue<TreeNode> travelQueue = new LinkedList<>();
        travelQueue.offer(root);
        TreeNode successor = null;
        while (!travelQueue.isEmpty()) {
            int level = travelQueue.size();
            for (int i = 0; i < level; i++) {
                TreeNode node = travelQueue.poll();
                if(node.val == key)
                {
                    return successor;
                }
                else{
                    successor = node;
                }
            }
        }
        return successor;
    }
}
