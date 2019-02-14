package Improved;

public class Solution23 {


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {

        if (pHead == null){
            return null;
        }

        ListNode countHead = hasCircle(pHead);
        if ( countHead == null){
            return null;
        }else {
            int k = countCircle(countHead);

            ListNode p1 = pHead;
            ListNode p2 = p1;
            for (int i = 0 ; i < k ; i++){
                p2 = p2.next;
            }

            while (p2 != p1){
                p2 = p2.next;
                p1 = p1.next;
            }

            return p1;
        }



    }

    private ListNode hasCircle(ListNode head){
        if (head == null || head.next == null){
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = p1.next;
        while (p2 != p1){

            if (p2 == null || p2.next ==null){
                return null;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return p1;


    }

    private int countCircle(ListNode listNode){
        int count = 1;
        ListNode countCircle = listNode.next;
        while (countCircle!=listNode){
            count ++;
            countCircle = countCircle.next;
        }
        return count;
    }


    public static void main(String[] args){


        ListNode listNode = new ListNode(1);
        //listNode.next.next.next = listNode.next;
        System.out.println(new Solution23().EntryNodeOfLoop(listNode));
    }



}
