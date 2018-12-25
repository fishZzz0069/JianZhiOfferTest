public class Test23 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    //判断是否有环，有环就返回环内节点
    public ListNode hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode p1 = head;
        ListNode p2 = head.next;


        while(p2 != p1){
            if(p2 == null || p2.next == null){
                return null;
            }

            p2 = p2.next.next;
            p1 = p1.next;

        }



        return p1;
    }

    //得到环内节点个数
    public int countNumber(ListNode head){

        ListNode p1 =hasCycle(head);
        if (p1 == null){
            return 0;
        }
        ListNode countStart = p1;
        int count = 0;
        while (p1.next != countStart){
            count++;
            p1 = p1.next;
        }
        return count+1;
    }

    //得到环的入口
    public ListNode getEntry(ListNode head){
        int n = countNumber(head);// get the count number of the circle;
        if (n == 0)
        {
            return null;
        }
        ListNode p1 = head ;
        ListNode p2 = p1;
        for (int i = 0 ; i < n ; i++){
            p2 = p2.next;
        }

        while (p2!=p1){
            p2 = p2.next;
            p1 = p1.next;
        }

        return p1;
    }

    public static void main(String[] args){


        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
       //listNode.next.next.next = listNode.next;
        System.out.println(new Test23().getEntry(listNode));
    }


}
