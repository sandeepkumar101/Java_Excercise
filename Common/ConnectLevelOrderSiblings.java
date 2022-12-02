package Common;
import java.util.*;

class TreeNode1 {
    public int val;
    public TreeNode1 left;
    public TreeNode1 right;
    public TreeNode1 next;

    TreeNode1(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    public void printLevelOrder() {
        TreeNode1 nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode1 current = nextLevelRoot;
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
    public static void connect(TreeNode1 root) {
        // TODO: Write your code here
        Queue<TreeNode1> travelQueue = new LinkedList<>();
        travelQueue.offer(root);
        while (!travelQueue.isEmpty()) {
            int level = travelQueue.size();
            for (int i = 0; i < level; i++) {
                TreeNode1 node = travelQueue.poll();
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
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(9);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        //root.printLevelOrder();
    }
}
