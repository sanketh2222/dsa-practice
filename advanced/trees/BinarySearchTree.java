

public class BinarySearchTree {

    public int solve(TreeNode A, int B) {
        if (A == null)
            return 0;
        else if (A.val == B)
            return 1;

        if (A.val <= B)
            return solve(A.right, B);
        else
            return solve(A.left, B);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(binarySearchTree.solve(root, 2));

    }
}
