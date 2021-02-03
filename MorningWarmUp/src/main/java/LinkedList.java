
public class LinkedList {

    public static void main(String[] args) {
        ListNode1 ln = new ListNode1(1);
        ln.next = new ListNode1(2);
        ln.next.next = new ListNode1(3);
        ln.next.next.next = new ListNode1(4);
        ln.next.next.next.next = new ListNode1(5);

      //  System.out.println(reverseList(ln.next));

    }

    public static ListNode1 reverseList(ListNode1 head) {
        ListNode1 previousNode = null;
        while (head != null) {
            ListNode1 temp = head.next;
            head.next = previousNode;
            previousNode = head;
            head = temp;
        }
        return previousNode;
    }

    public static ListNode1 reverseList2(ListNode1 head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode1 previousNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return previousNode;
    }

}
    class ListNode1 {
        int val;
        ListNode1 next;
        ListNode1() {}
        ListNode1(int val) { this.val = val; }
        ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
    }