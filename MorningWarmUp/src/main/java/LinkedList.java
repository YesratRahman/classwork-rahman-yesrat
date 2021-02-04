
public class LinkedList {

    public static void main(String[] args) {
        ListNode head = null;
        ListNode node = new ListNode(1);
        head = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;


        LinkedList main = new LinkedList();
        head = main.swapPairs1(head);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }

    //https://leetcode.com/problems/swap-nodes-in-pairs/submissions/
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = head.next;
        head.next = swapPairs(node.next);   //head.next.next
        node.next = head;
        return node;
    }


    //https://leetcode.com/problems/swap-nodes-in-pairs/submissions/
    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode currentNode = head;
        ListNode newHeadNode = head.next;

        while(currentNode!= null && currentNode.next != null){
            ListNode tempNode = currentNode;
            currentNode = currentNode.next;
            tempNode.next = currentNode.next;
            currentNode.next = tempNode;
            currentNode = tempNode.next;


            if(currentNode!= null && currentNode.next != null)
                tempNode.next = currentNode.next;

        }
        return newHeadNode;
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