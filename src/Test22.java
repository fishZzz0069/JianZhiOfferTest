public class Test22 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


  public ListNode delKNode(ListNode head, int k){

         if (head == null || k == 0)
         {
             return null;
         }

         ListNode p1 = head;
         ListNode p2 = head;

         for (int i = 0 ; i < k-1 ; i ++){

             if (p2.next!=null){
                 p2 = p2.next;
             }else {
                 return null;
             }
         }

        while (p2.next!=null){

             p1 =p1.next;
             p2 = p2.next;
        }

        return p1;
  }

  public static void main(String[] args){


      ListNode listNode = new ListNode(2);
      listNode.next =new ListNode(3);
      listNode.next.next =new ListNode(4);
      listNode.next.next.next =new ListNode(5);
      System.out.println(new Test22().delKNode(listNode,5));
  }
}
