public class DetectCycle {
    class ListNode {

        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public ListNode solve(ListNode A) {
        // detect the cycle -> meet point
        // find the starting point -> start of the cycle
        // remove cycle : from the start of the cycle iterate till the next node is not
        // the start node
        // while iteration if we get the start node then point it to null
        ListNode temp = A;
        ListNode cycleStartPoint = detectCycle(temp);
        if (cycleStartPoint != null)
            removeCycle(cycleStartPoint, temp);

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

        return null; // no cycle

    }

    // find starting node of the loop
    // start point of the node where the loop starts
    private ListNode getStartPoint(ListNode intersectPoint, ListNode head) {
        ListNode temp = head;
        ListNode tempNode = intersectPoint;

        while (tempNode != temp) {
            // head = head.next;
            temp = temp.next;
            tempNode = tempNode.next;
        }

        return temp;
    }

    // intersection point refers to the point where slow and fast pointers
    // meet in the cycle
    private void removeCycle(ListNode intersectPoint, ListNode head) {

        ListNode startPoint = getStartPoint(intersectPoint, head);
        ListNode tempNode = startPoint;

        while (tempNode.next != startPoint) {
            tempNode = tempNode.next;
        }

        tempNode.next = null;
    }
}
