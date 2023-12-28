import java.util.*;

public class ZigZagTraversal {

    private List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> zigZagOrderLst = new ArrayList<>();
        queue.add(root);
        zigZagOrderLst.add(Arrays.asList(root.val));
        int currLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    level.add(node.left.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    level.add(node.right.val);
                }
            }
            currLevel += 1;

            if (currLevel % 2 == 1) {
                Collections.reverse(level);
            }
            if (level.size() > 0)
                zigZagOrderLst.add(level);

        }
        return zigZagOrderLst;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> zigZagOrderLst = new ArrayList<>();

        if (root == null) {
            return zigZagOrderLst;
        }

        queue.add(root);
        zigZagOrderLst.add(Arrays.asList(root.val));
        boolean leftToRight = false;

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (TreeNode node : queue) {
                if (node.left != null) {
                    if (leftToRight) {
                        queue.addFirst(node.left);
                    } else {
                        queue.addLast(node.left);
                    }
                    level.add(node.left.val);
                }
                if (node.right != null) {
                    if (leftToRight) {
                        queue.addFirst(node.right);
                    } else {
                        queue.addLast(node.right);
                    }
                    level.add(node.right.val);
                }
            }

            leftToRight = !leftToRight;
            if (level.size() > 0)
                zigZagOrderLst.add(level);
        }
        return zigZagOrderLst;
    }

    public static void main(String[] args) {
        ZigZagTraversal traversal = new ZigZagTraversal();
        // TreeNode root = getTestCase1(); // [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(1); // [1]
        System.out.println(traversal.levelOrder(root));
        new ArrayList<>(1);
    }

    private static TreeNode getTestCase1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }
}
