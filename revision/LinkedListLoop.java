package revision;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListLoop {

    public ListNode solve(ListNode A) {
        // detect the cycle -> meet point
        // find the starting point -> start of the cycle
        // remove cycle : from the start of the cycle iterate till the next node is not
        // the start node
        // while iteration if we get the start node then point it to null
        ListNode temp = A;
        ListNode meetPoint = detectCycle(temp);
        if (meetPoint != null)
            removeCycle(meetPoint, temp);

        return temp;

    }

    private ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }

        return null;

    }

    // find starting node of the loop
    // start point of the node where the loop starts
    private ListNode getStartPoint(ListNode meetPoint, ListNode head) {
        ListNode temp = head;

        // there is no cycle since slow and fast dont meet
        if (meetPoint == null) {
            return null;
        }

        ListNode tempNode = meetPoint;

        while (tempNode != temp) {
            // head = head.next;
            temp = temp.next;
            tempNode = tempNode.next;
        }

        return temp;
    }

    private void removeCycle(ListNode meetPoint, ListNode head) {

        ListNode startPoint = getStartPoint(meetPoint, head);

        ListNode tempNode = startPoint;

        while (tempNode.next != startPoint) {
            tempNode = tempNode.next;
        }

        tempNode.next = null;
        // return tempNode;
    }

    public static void main(String[] args) {

    }
}
