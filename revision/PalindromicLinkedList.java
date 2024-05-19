package revision;

//class ListNode {
//    public int val;
//    public ListNode next;
//
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}

public class PalindromicLinkedList {

    public int isPalindrome(ListNode A) {
        // LOGIC : is LL is a palindrome then first half = reversed 2nd half

        // find out the mid
        ListNode dum = A;
        ListNode mid = getMid(A);
        ListNode tail = reverse(mid.next);

        mid.next = tail;

        mid = mid.next;

        while (mid != null) {

            if (dum.val != mid.val) {
                return 0;
            }

            mid = mid.next;
            dum = dum.next;
        }

        return 1;

    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode h2 = null;
        ListNode h1 = head;
        ListNode temp = head;

        if (head == null || head.next == null) { return head;}
        

        while (h1 != null) {
            // temp.next = h2;
            // h1 = h1.next;
            // h2 = temp;
            // temp = h1;
            h1 = h1.next;
            temp.next = h2;
            h2 = temp;
            temp = h1;
        }

        return h2;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(6);//6 3 7 3 6
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(7);
        node1.next.next.next = new ListNode(3);
        node1.next.next.next.next = new ListNode(6);
        PalindromicLinkedList list = new PalindromicLinkedList();
        System.out.println(list.isPalindrome(node1));

    }
}
