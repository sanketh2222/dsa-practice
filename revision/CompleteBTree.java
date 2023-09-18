package revision;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBTree {

    public static TreeNode deserialize(int[] serializedTree) {
        if (serializedTree == null || serializedTree.length == 0)
            return null;
        return deserializeHelper(serializedTree);
    }

    private static TreeNode deserializeHelper(int[] A) {
        TreeNode root = new TreeNode(A[0]);
        Queue<TreeNode> q = new LinkedList<>();
        int index = 1;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            if (temp == null)
                continue;
            TreeNode node;
            for (int i = 0; i < 2; i++) {// for left and right child
                if (index < A.length && A[index] == -1) {
                    node = null;
                } else
                    node = new TreeNode(A[index]);
                index++;
                if (i % 2 == 0) {
                    temp.left = node;
                    q.add(temp.left);
                } else {
                    temp.right = node;
                    q.add(temp.right);
                }
            }
        }
        return root;
    }

    public static int solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.right != null && node.left == null) {
                return 0;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return 1;
    }

    private int getNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getNodeCount(root.left) + getNodeCount(root.right) + 1;

    }

    public static void main(String[] args) {
        int[] serializedTree = { 15, 1, 2, 3, 5, 6, 4, -1, -1, -1, -1, -1, 7, -1, -1, -1 };
        CompleteBTree bTree = new CompleteBTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        // root.right.right = new TreeNode(11);
        System.out.println(solve(root));
        System.out.println(serializedTree.length);
        System.out.println(bTree.getNodeCount(root));

    }
}
