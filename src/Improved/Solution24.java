package Improved;

public class Solution24 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList2(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode rhead = ReverseList2(head.next);


        head.next.next = head;
        head.next = null;


        return rhead;
    }

    public ListNode ReverseList(ListNode head) {

        if (head == null){
            return null;
        }

        if (head.next == null){
            return head;
        }

        if (head.next.next == null){
            head.next.next = head;
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = head.next.next;

        while (p2.next!=null){
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }

        p2.next = p1;
        return p2;


    }
}
