

public class ListNode implements Cloneable {

    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public CountSort geSort() {
        return new CountSort();
    }

    @Override
    public ListNode clone() throws CloneNotSupportedException {
        return (ListNode) super.clone();
    }
}
