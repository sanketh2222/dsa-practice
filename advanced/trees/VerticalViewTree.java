

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalViewTree {

    private Map<Integer, List<Integer>> map = new HashMap<>();
    private int maxDist = Integer.MIN_VALUE;
    private int minDist = Integer.MAX_VALUE;

    public class TreeInfo {
        TreeNode treeNode;
        int distance;

        TreeInfo(TreeNode treeNode, int distance) {
            this.treeNode = treeNode;
            this.distance = distance;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        getVerticalViewMap(A);
        for (int i = minDist; i <= maxDist; i++) {
            list.add(new ArrayList<>(map.get(i)));
        }
        return list;
    }

    private void getVerticalViewMap(TreeNode root) {
        Queue<TreeInfo> queue = new LinkedList<>();

        queue.add(new TreeInfo(root, 0));

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeInfo treeInfo = queue.poll();

                if (treeInfo.treeNode.left != null)
                    queue.add(new TreeInfo(treeInfo.treeNode.left, treeInfo.distance - 1));

                if (treeInfo.treeNode.right != null)
                    queue.add(new TreeInfo(treeInfo.treeNode.right, treeInfo.distance + 1));

                if (!map.containsKey(treeInfo.distance)) {
                    map.put(treeInfo.distance, new ArrayList<>());
                    minDist = Math.min(treeInfo.distance, minDist);
                    maxDist = Math.max(maxDist, treeInfo.distance);
                }

                map.get(treeInfo.distance).add(treeInfo.treeNode.val);
            }
        }

    }

    // Below method will not maintain the order
    private void preOrder(TreeNode root, int dist) {

        if (root == null)
            return;

        minDist = Math.min(minDist, dist);
        maxDist = Math.max(maxDist, dist);

        if (!map.containsKey(dist)) {
            map.put(dist, new ArrayList<>());
        }

        map.get(dist).add(root.val);
        preOrder(root.left, dist - 1);
        preOrder(root.right, dist + 1);

    }

    public static void main(String[] args) {
        VerticalViewTree verticalViewTree = new VerticalViewTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.left.left.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        verticalViewTree.verticalOrderTraversal(root)
                .forEach(System.out::print);
        // System.out.println(verticalViewTree.map.entrySet());

    }
}
