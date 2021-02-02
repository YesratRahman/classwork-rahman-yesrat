
public class LinkedList {

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(4);
        ln.next.next.next.next = new ListNode(5);

      //  System.out.println(reverseList(ln.next));

    }

    public static ListNode reverseList(ListNode head) {
        ListNode previousNode = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = previousNode;
            previousNode = head;
            head = temp;
        }
        return previousNode;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previousNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return previousNode;
    }

}
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }