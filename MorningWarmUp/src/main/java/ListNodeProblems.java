import java.util.ArrayList;

public class ListNodeProblems {

    public static void main(String[] args) {
        ListNode ln = new ListNode(3);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(0);
        ln.next.next.next = new ListNode(-4);
        ln.next.next.next.next = ln.next;
        System.out.println(ln.next.next.next.next.val);
        Boolean node = hasCycle(ln);
        System.out.println(node);

    }
    
    //https://leetcode.com/problems/linked-list-cycle/submissions/
    //Slower
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ArrayList<ListNode> array = new ArrayList<>();
        ListNode newNode = head;

        while (newNode != null && newNode.next != null) {
            if (array.contains(newNode)) {
                return true;
            }
            array.add(newNode);
            newNode = newNode.next;
        }
        return false;
    }

    //Faster approach
    public static boolean hasCycle1(ListNode head) {
        if (head == null) return false;

        ListNode hare = head.next;

        while (hare != null && hare.next != null) {
            head = head.next;
            hare = hare.next.next;
            if (head == hare) return true;
        }
        return false;
    }

}



// class ListNode {
//     int val;
//     ListNode next;
//
//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }
