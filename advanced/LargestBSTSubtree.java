package advanced;

import java.util.List;

public class LargestBSTSubtree {

    int ans = 1;

    public class TreeInfo {
        int min;
        int max;
        boolean isBst;
        int size;

        public TreeInfo(int min, int max, boolean isBst, int size) {
            this.min = min;
            this.max = max;
            this.isBst = isBst;
            this.size = size;
        }
    }

    public int solve(TreeNode A) {
        maxBSTSubTree(A);
        return ans;
    }

    private TreeInfo maxBSTSubTree(TreeNode root) {
        if (root == null) {
            return new TreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
        }

        if (root.left == null && root.right == null) {
            return new TreeInfo(root.val, root.val, true, 1);
        }

        TreeInfo left = maxBSTSubTree(root.left);
        TreeInfo right = maxBSTSubTree(root.right);

        if (left.isBst && right.isBst && root.val > left.max && root.val < right.min) {
            ans = Math.max(ans, left.size + right.size + 1);
            return new TreeInfo(left.min, right.max, true, left.size + right.size + 1);
        }

        return new TreeInfo(
                Math.min(Math.min(left.min, right.min), root.val),
                Math.max(Math.max(left.max, right.max), root.val),
                false,
                left.size + right.size + 1);

    }

    public static void main(String[] args) {
        LargestBSTSubtree bstSubtree = new LargestBSTSubtree();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(14);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(11);
        System.out.println(bstSubtree.solve(root));
    }
}
