public class Test18 {

    static class ListNode{
        int data;
        ListNode next;

        ListNode(int v){
            this.data = v;
        }
    }


    public void deleteNode(ListNode head,ListNode deListNode){
        if(deListNode == null || head == null){
            return ;
        }
        if(head == deListNode){
            head =null;
        }
        else{
            if(deListNode.next == null){
                ListNode pinitListNode = head;
                while(pinitListNode.next.next != null){
                    pinitListNode = pinitListNode.next;
                }
                pinitListNode.next = null;
            }else{
                deListNode.data = deListNode.next.data;
                deListNode.next = deListNode.next.next;
            }
        }
    }



//    public:
//        ListNode* deleteDuplication(ListNode* pHead)
//        {
//            if (pHead==NULL)
//                return NULL;
//            if (pHead!=NULL && pHead->next==NULL)
//                return pHead;
//
//            ListNode* current;
//
//            if ( pHead->next->val==pHead->val){
//                current=pHead->next->next;
//                while (current != NULL && current->val==pHead->val)
//                    current=current->next;
//                return deleteDuplication(current);
//            }
//
//            else {
//                current=pHead->next;
//                pHead->next=deleteDuplication(current);
//                return pHead;
//            }
//        }

}
