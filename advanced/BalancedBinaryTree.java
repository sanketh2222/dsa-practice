package advanced;

public class BalancedBinaryTree {

    public class TreeInfo {
        int height;
        boolean isBalanced;

        TreeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public int isBalanced(TreeNode A) {
        return isBTBalanced(A).isBalanced ? 1 : 0;
    }

    private TreeInfo isBTBalanced(TreeNode root) {
        if (root == null) {
            return new TreeInfo(1, true);
        }

        TreeInfo lt = isBTBalanced(root.left);
        TreeInfo rt = isBTBalanced(root.right);

        if ((Math.abs(lt.height - rt.height) <= 1) &&
                (lt.isBalanced && rt.isBalanced))
            return new TreeInfo(
                    Math.max(rt.height, lt.height) + 1,
                    true);

        return new TreeInfo(Math.abs(lt.height - rt.height), false);
    }

    public static void main(String[] args) {

    }
}
