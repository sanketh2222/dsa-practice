

public class Merge2SortedLists {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
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

    }
}
