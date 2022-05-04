package Common;
import java.util.*;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    TreeNode(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    public void printLevelOrder() {
        TreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};

class ConnectLevelOrderSiblings {
    public static void connect(TreeNode root) {
        // TODO: Write your code here
        Queue<TreeNode> travelQueue = new LinkedList<>();
        travelQueue.offer(root);
        while (!travelQueue.isEmpty()) {
            int level = travelQueue.size();
            for (int i = 0; i < level; i++) {
                TreeNode node = travelQueue.poll();
                if (i < level - 1) {
                    node.next = travelQueue.peek();
                }
                if (node.left != null)
                    travelQueue.add(node.left);
                if (node.right != null)
                    travelQueue.add(node.right);
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        //root.printLevelOrder();
    }
}
