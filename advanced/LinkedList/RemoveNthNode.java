
public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode temp = A;
        int k = getLength(temp);

        if (B >= k) {
            A = temp.next;
            return A;
        }

        while ((k - B) > 1) {
            temp = temp.next;
            k--;
        }
        ListNode intNode = temp;
        temp = temp.next;
        temp = temp.next;

        intNode.next = temp;

        return A;
    }

    public ListNode removeNthFromEndII(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        int k = getLength(head) - n;
        ListNode temp = head;
        ListNode prev = null;

        while (k > 0) {
            prev = temp;
            temp = temp.next;
            k--;
        }
        if (prev == null) {
            return temp.next;
        }
        
        prev.next = temp.next;

        return head;

    }

    private int getLength(ListNode node) {
        int length = 0;
        ListNode temp = node;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;

    }

    public static void main(String[] args) {
        RemoveNthNode nthNode = new RemoveNthNode();
        // 1, 2, 3, 4, 5
        // B = 2
        ListNode node1 = new ListNode(1);
        // ListNode node2 = new ListNode(2);
        // ListNode node3 = new ListNode(3);
        // ListNode node4 = new ListNode(4);
        // ListNode node5 = new ListNode(5);

        // node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;
        // node4.next = node5;

        ListNode ans = nthNode.removeNthFromEnd(node1, 1);

        ListNode temp = ans;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
}
