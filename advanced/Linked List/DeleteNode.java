public class DeleteNode {

    public void deleteNode(ListNode node) {

        if (node.next == null) {// last node
            node = null;
        } else {
            ListNode nextNode = node.next;
            node.val = nextNode.val;
            node.next = nextNode.next;
        }

    }
}
