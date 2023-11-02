

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode first = null, from = null, last = null;
        ListNode to = null;

        ListNode curr = A, head = A;

        int count = 0;

        while (curr != null) {
            count += 1;
            if (count < B) {
                first = curr;
            }

            if (count == B) {
                from = curr;
            }

            if (count == C) {
                to = curr;
                last = to.next;
                break;
            }

            // curr.next = null; changes the value of first 
            curr = curr.next; // does not change the value of first
        }

        to.next = null;

        reverseList(from);

        if (first != null)
            first.next = to;
        else
            head = to;

        from.next = last;

        return head;

    }

    private ListNode reverseList(ListNode A) {
        ListNode resultHead = null;
        ListNode currHead = A, temp = currHead;

        if (A == null)
            return A;

        while (currHead != null) {
            temp = currHead;
            currHead = currHead.next;
            temp.next = resultHead;
            resultHead = temp;
        }

        return resultHead;
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 B = 2 C = 3
        // 1 -> 3 -> 2

        // ListNode node1 = createLinkedList();

        ListNode node1 = createdLL();

        ReverseLinkedListII ii = new ReverseLinkedListII();
        ListNode head = ii.reverseBetween(node1, 2, 4);
        ListNode temp = head;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

    private static ListNode createdLL() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        return node1;
    }

    private static ListNode createLinkedList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        return node1;
    }
}
