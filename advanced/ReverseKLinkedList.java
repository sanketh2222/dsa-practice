package advanced;

public class ReverseKLinkedList {

    public ListNode reverseList(ListNode A, int B) {
        if (B == 1 || A == null)
            return A;

        // Assumption: the function will reverse the list and return the head of the
        // reversed node
        ListNode h1 = A, h2 = null, temNode = h1;

        int totalNodesToReverse = B;
        while (totalNodesToReverse > 0 && h1 != null) {
            temNode = h1;
            h1 = h1.next;
            temNode.next = h2;
            h2 = temNode;
            totalNodesToReverse--;

        }
        A.next = reverseList(h1, B);
        return h2;
    }

    public static void main(String[] args) {
        ReverseKLinkedList kLinkedList = new ReverseKLinkedList();
        // 6 -> 10 -> 0 -> 3 -> 4 -> 8 and B = 3
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        // kLinkedList.reverseList(node6, 3);
        System.out.println(Math.floor(19));
    }
}
