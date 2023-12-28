import javafx.scene.Node;

class ListNode {
    int val;
    ListNode right, down;

    ListNode(int x) {
        val = x;
        right = down = null;
    }
}

public class FlattenLL {

    ListNode flatten(ListNode root) {
        if (root == null || root.down == null) {
            return root;
        }

        ListNode mid = getMid(root);
        ListNode h1 = mid.down;
        mid.down = null;
        root = flatten(root);
        ListNode p2 = flatten(h1);

        return merge(root, p2);

    }

    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }

        return slow;
    }

    private ListNode merge(ListNode A, ListNode B) {
        // Selection of head node of the merged list
        ListNode head = null, temp = null;
        if (A.val < B.val) {
            head = A;
            A = A.right;
        } else {
            head = B;
            B = B.right;
        }

        temp = head;

        while (A != null && B != null) {
            if (A.val < B.val) {
                temp.right = A;
                A = A.right;
            } else {
                temp.right = B;
                B = B.right;
            }

            temp = temp.right;
        }

        while (A != null) {
            temp.right = A;
            temp = temp.right;
            A = A.right;
        }

        while (B != null) {
            temp.right = B;
            temp = temp.right;
            B = B.right;
        }
        return head;
    }
}
