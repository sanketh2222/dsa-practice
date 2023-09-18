package revision;

public class IdenticalBTree {

    public int isSameTree(TreeNode A, TreeNode B) {
        return preOrder(A, B);
    }

    private int preOrder(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return 1;
        }

        if (node1 != null && node2 == null || node1 == null && node2 != null) {
            return 0;
        }

        if (node1.val != node2.val) {
            return 0;
        }

        int isLstSame = preOrder(node1.left, node2.left);
        int isRstSame = preOrder(node1.right, node2.right);

        return isLstSame == 1 && isRstSame == 1 ? 1 : 0;
    }

    private TreeNode getFirstTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = null;

        return root;

    }

    private TreeNode getNextTree() {
        TreeNode root = new TreeNode(5);
        root.left = null;
        root.right = null;

        return root;

    }

    public static void main(String[] args) {
        IdenticalBTree bTree = new IdenticalBTree();
        TreeNode A = bTree.getFirstTree();
        TreeNode B = bTree.getNextTree();
        System.out.println(bTree.isSameTree(A, B));


    }
}
