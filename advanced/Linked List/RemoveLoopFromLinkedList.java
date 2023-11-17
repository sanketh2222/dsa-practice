public class RemoveLoopFromLinkedList {
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
        detectCycle(temp);
        return temp;

    }

    private void detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) {
            ListNode startPoint = getStartPoint(slow, head);

            ListNode tempNode = startPoint;

            while (tempNode.next != startPoint) {
                tempNode = tempNode.next;
            }

            tempNode.next = null;
            // return tempNode;

        } 

    }

    // find starting node of the loop
    // start point of the node where the loop starts
    private ListNode getStartPoint(ListNode meetPoint, ListNode head) {
        ListNode temp = head;

        while (meetPoint != temp) {
            head = head.next;
            temp = temp.next;
        }

        return temp;
    }

    public static void main(String[] args) {
        RemoveLoopFromLinkedList linkedList = new RemoveLoopFromLinkedList();
        ListNode listNode = new ListNode(6);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(8);
        // 6 -> 5 -> 5 -> 3 -> 8
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode head = linkedList.solve(listNode);
        ListNode temp = head;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
}
