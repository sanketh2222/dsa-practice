package dsa-practice.advanced.LinkedList;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class OddEvenLinkedList {

    public ListNode solve(ListNode A) {
        if (A.next == null) {
            return A;
        }

        ListNode odd = A;
        ListNode even = A.next;
        ListNode evenStart = A.next;

        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenStart;

        return odd;
    }

    public static void main(String[] args) {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        // A = 5 -> 7 -> 6 -> 2 -> 9 -> NULL
        ListNode A = new ListNode(5);
        A.next = new ListNode(7);
        A.next.next = new ListNode(6);
        A.next.next.next = new ListNode(2);
        A.next.next.next.next = new ListNode(9);
        ListNode head = oddEvenLinkedList.solve(A);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
