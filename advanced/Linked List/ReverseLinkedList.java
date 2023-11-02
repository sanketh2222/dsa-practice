

public class ReverseLinkedList {

    public ListNode reverseList(ListNode A) {
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
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
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

        ListNode node = reverseLinkedList.reverseList(node1);
        
        ListNode temp = node;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
           
        }

    }
}
