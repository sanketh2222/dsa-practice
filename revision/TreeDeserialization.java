package revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class TreeDeserialization {

    public TreeNode solve(int[] A) {
        return constructTree(A, 0);
    }

    private TreeNode constructTree(int[] arr, int idx) {
        if (idx > arr.length) {
            return null;
        }

        if (arr[idx] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[idx]);

        int leftIdx = 2 * idx + 1; // Index of the left child
        int rightIdx = 2 * idx + 2; // Index of the right child

        root.left = constructTree(arr, leftIdx);
        root.right = constructTree(arr, rightIdx);

        return root;
    }

    public void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        printTreeHelper(root, "");
    }

    private void printTreeHelper(TreeNode node, String prefix) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + "├── " + node.val);

        String childPrefix = prefix + "│   ";
        printTreeHelper(node.left, childPrefix + "├── Left: ");
        printTreeHelper(node.right, childPrefix + "└── Right: ");
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1 };
        // int[] arr = { 1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1 };
        TreeDeserialization deserialization = new TreeDeserialization();
        TreeNode root = deserialization.solve(arr);
        System.out.println(root);
        deserialization.printTree(root);
    }
}
