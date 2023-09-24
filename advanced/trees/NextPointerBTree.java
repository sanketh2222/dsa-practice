class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    public TreeLinkNode(int val) {
        this.val = val;
        this.left = this.right = this.next = null;
    }
}

public class NextPointerBTree {

    public TreeLinkNode connect(TreeLinkNode root) {
        if (root == null)
            return null;

        // Helper function to connect nodes at the same level
        connectNodes(root);

        return root;
    }

    private void connectNodes(TreeLinkNode node) {
        if (node == null)
            return;

        if (node.left != null) {
            node.left.next = node.right;
        }

        if (node.right != null) {
            node.right.next = (node.next != null) ? node.next.left : null;
        }

        connectNodes(node.left);
        connectNodes(node.right);
    }

    public static void main(String[] args) {

    }
}
