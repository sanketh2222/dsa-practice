package advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopViewBinaryTree {

    private Map<Integer, Integer> map = new HashMap<>();
    private int maxDist = Integer.MIN_VALUE;
    private int minDist = Integer.MAX_VALUE;

    public class TreeInfo {
        public TreeNode treeNode;
        public int distance;

        TreeInfo(TreeNode treeNode, int distance) {
            this.treeNode = treeNode;
            this.distance = distance;
        }
    }

    public ArrayList<Integer> solve(TreeNode A) {
        List<Integer> result = new ArrayList<>();
        getTopView(A);
        for (int i = minDist; i <= maxDist; i++) {
            result.add(map.get(i));
        }
        return new ArrayList<>(result);
    }

    private void getTopView(TreeNode root) {
        Queue<TreeInfo> queue = new LinkedList<>();

        queue.add(new TreeInfo(root, 0));

        while (!queue.isEmpty()) {

            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeInfo node = queue.poll();

                if (node.treeNode.left != null)
                    queue.add(new TreeInfo(node.treeNode.left, node.distance - 1));

                if (node.treeNode.right != null)
                    queue.add(new TreeInfo(node.treeNode.right, node.distance + 1));

                if (!map.containsKey(node.distance)) {
                    map.put(node.distance, node.treeNode.val);
                    minDist = Math.min(minDist, node.distance);
                    maxDist = Math.max(maxDist, node.distance);
                }
            }
        }

    }

    public static void main(String[] args) {
        TopViewBinaryTree topViewBinaryTree = new TopViewBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.left.left.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        topViewBinaryTree.solve(root)
                .forEach(System.out::println);

    }
}
