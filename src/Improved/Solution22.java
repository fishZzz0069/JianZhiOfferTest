package Improved;

public class Solution22 {

   public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
             this.val = val;
        }
}
    public ListNode FindKthToTail(ListNode head,int k) {

       if (head == null || k <= 0  ){
           return null;
       }

       ListNode p1 = head;
       ListNode p2 = head;
       for (int i = 0  ; i < k ; i++){
           if (p1.next != null){
               p1 = p1.next;
           }else {
               if(i+1 == k){
                   return p2;
               }else{
                   return null;
               }
           }
       }

       while (p1.next != null){
           p1 = p1.next;
           p2 = p2.next;
       }

       return p2.next;


    }
}
