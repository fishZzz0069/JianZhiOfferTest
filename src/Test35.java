public class Test35 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode sibling;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("value = " + val);
            sb.append(", next = " + (next == null ? "null" : next.val));
            sb.append(", sbiling = " + (sibling == null ? "null" : sibling.val));
            return sb.toString();
        }

    }
    public ListNode duplicateLinkedList(ListNode head){


        if (head == null )
            return null;

        ListNode dummyhead = head;

        while (head!=null){
            ListNode newnode = new ListNode(head.val);
            newnode.next = head.next;
            head.next = newnode;
            head = newnode.next;
        }

        head = dummyhead;
        while (head!=null){
            if (head.sibling != null){
                head.next.sibling = head.sibling.next;
            }
            head = head.next.next;
        }

        head = dummyhead;
        ListNode clonedHead = head.next;
        ListNode resHead = clonedHead;
        head = head.next.next.next;
        while (head!=null){

            clonedHead.next = head;
            clonedHead = clonedHead.next;
            if (head.next == null)
                break;
            head = head.next.next;







        }

        return resHead;

    }

    public static void main(String[] args){
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNode.sibling = listNode.next.next;
        listNode.next.next.sibling = listNode;
        System.out.println(new Test35().duplicateLinkedList(listNode).next.next);
    }
}
