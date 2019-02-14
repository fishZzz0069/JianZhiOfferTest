package Improved;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead =  new ListNode(0);

        dummyHead.next = head;
        ListNode preNode = dummyHead;
        ListNode currentNode = head;
        boolean curIsDelete = false;
        while(currentNode!=null && currentNode.next!=null){
            if(currentNode.next.val == currentNode.val){
                curIsDelete = true;
                currentNode.next = currentNode.next.next;
            }
            else{
                if(curIsDelete){

                    preNode.next = currentNode.next;
                    currentNode = preNode.next;
                    curIsDelete = false;

                }else{
                    preNode = preNode.next;
                    currentNode = currentNode.next;
                }
            }


        }

        if(curIsDelete){

            preNode.next = currentNode.next;
            currentNode = preNode.next;
            curIsDelete = false;

        }

        return dummyHead.next;

    }
    public void deleteNode(ListNode node) {
        node = node.next;
        node.next = node.next.next;
    }
    static ListNode head = new ListNode(1);
    public static void main(String[] args){

        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(8);

        new Solution().deleteDuplicates(head);
        System.out.println(head.next.next.val);



    }
}