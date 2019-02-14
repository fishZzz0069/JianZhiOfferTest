package Improved;

public class Solution25 {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode mergeHead = null;

        if(list1 == null){
            return list2;
        }

        if (list2 == null){
            return list1;
        }

        if (list1.val > list2.val ){
            mergeHead = list2;
            mergeHead.next = Merge(list2.next,list1);
        }else {
            mergeHead = list1;
            mergeHead.next = Merge(list1.next,list2);
        }

        return mergeHead;
    }
}
