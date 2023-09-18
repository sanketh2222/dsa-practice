package revision;

public class AliceAndEvenIndices {

    public ListNode solve(ListNode A) {
        ListNode curr = null, prev = A, next = null;
        ListNode tempHead = A;

        while (A.val % 2 == 1) {
            A = A.next;
        }
        tempHead = A;
        prev = A;

        while (tempHead != null) {

            if (tempHead.val % 2 == 1) {
                deleteNode(prev);
            } else {
                prev = tempHead;
            }

            tempHead = tempHead.next;
        }

        return A;

    }

    private void deleteNode(ListNode node) {

        if (node.next != null) {
            ListNode next = node.next.next;
            node.next = next;

        } else {
            node.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(7);
        // head.next.next.next.next.next = new ListNode(17);
        AliceAndEvenIndices indices = new AliceAndEvenIndices();
        ListNode temp = indices.solve(head);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
