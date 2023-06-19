package revision;

import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class NextRightPointer {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode levelStart = root;

        while (levelStart.left != null) {
            TreeLinkNode curr = levelStart;

            while (curr != null) {
                curr.left.next = curr.right;

                if (curr.next != null)
                    curr.right.next = curr.next.left;

                curr = curr.next;
            }

            levelStart = levelStart.left;
        }
    }

    public void connectWithQueue(TreeLinkNode root) {
        if (root == null)
            return;

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeLinkNode node = queue.poll();

                if (i < levelSize - 1)
                    node.next = queue.peek();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
}
