package advanced;

public class TreeDiameter {

    public class TreeInfo {
        public int height;
        public int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public int solve(TreeNode A) {
        TreeInfo ans = diameter(A);
        return Math.max(ans.height, ans.diameter);
    }

    private TreeInfo diameter(TreeNode root) {
        if (root == null)
            return new TreeInfo(-1, -1);

        TreeInfo lt = diameter(root.left);
        TreeInfo rt = diameter(root.right);

        return new TreeInfo(Math.max(lt.height, rt.height) + 1,
                Math.max(Math.max(lt.diameter, rt.diameter), lt.height + rt.height + 2));
    }

    public static void main(String[] args) {

    }
}
