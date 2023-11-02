

public class MergeSortLinkedList {
    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null)
            return A;

        ListNode mid = getFirstMid(A);
        ListNode head = A;
        ListNode h2 = mid.next;

        mid.next = null;
        head = sortList(head);
        h2 = sortList(h2);
        return merge(head, h2);
    }

    private ListNode getFirstMid(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode A, ListNode B) {
        // Selection of head node of the merged list
        ListNode head = null, temp = null;
        if (A.val < B.val) {
            head = A;
            A = A.next;
        } else {
            head = B;
            B = B.next;
        }

        temp = head;

        while (A != null && B != null) {
            if (A.val < B.val) {
                temp.next = A;
                A = A.next;
            } else {
                temp.next = B;
                B = B.next;
            }

            temp = temp.next;
        }

        while (A != null) {
            temp.next = A;
            temp = temp.next;
            A = A.next;
        }

        while (B != null) {
            temp.next = B;
            temp = temp.next;
            B = B.next;
        }
        return head;
    }

    public static void main(String[] args) {
        //3, 4, 2, 8
        MergeSortLinkedList mergeSortLinkedList = new MergeSortLinkedList();
        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(8);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode sortedHead = mergeSortLinkedList.sortList(listNode);
        ListNode temp = sortedHead;
        while (temp!= null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
}
