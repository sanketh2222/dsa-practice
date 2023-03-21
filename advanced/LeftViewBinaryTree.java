package advanced;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewBinaryTree {

    private List<Integer> leftViewList = new ArrayList<>();

    public ArrayList<Integer> solve(TreeNode A) {
        leftViewBetter(A);
        return new ArrayList<>(leftViewList);
    }

    private void leftView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int n = queue.size();
            int leftFirstNode = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (i == 0) {
                    leftFirstNode = node.val;
                }
            }

            leftViewList.add(leftFirstNode);
        }

    }


    private void leftViewBetter(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // Add a "dummy" node to mark the end of the first level
        int level = 1; // Initialize the level to 1
        int leftMostNode = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null); // Add a "dummy" node to mark the end of the next level
                }
                leftViewList.add(leftMostNode);
                leftMostNode = 0;
                level++;
            } else {
                if (level == 1) {
                    leftMostNode = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        LeftViewBinaryTree leftViewBinaryTree = new LeftViewBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.left.left.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        // leftViewBinaryTree.solve(root)
        //         .forEach(System.out::println);

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(1);
        q.addLast(2);
        System.out.println(q.peekFirst());
        System.out.println(q.peekLast());
        System.out.println(q.getLast());

    }
}
