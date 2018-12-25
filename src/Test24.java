public class Test24 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode rhead = reverseList(head.next);


        head.next.next = head;
        head.next = null;


        return rhead;
    }

    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }


        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {

            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args){


        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        //listNode.next.next.next = listNode.next;
        System.out.println(new Test24().reverseList2(listNode));
    }
}
