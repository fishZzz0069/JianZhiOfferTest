import java.util.Stack;

public class Test52 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getCommonListNode(ListNode root1 , ListNode root2){
        if (root1 == null || root2 == null)
            return null;


        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        stack1.push(root1);
        while (root1.next != null){
            stack1.push(root1.next);
            root1 = root1.next;
        }
        stack2.push(root2);
        while (root2.next != null){
            stack2.push(root2.next);
            root2 = root2.next;
        }


        ListNode tempCommon = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            ListNode listNode1 = stack1.pop();
            ListNode listNode2 = stack2.pop();
            if (listNode1 == listNode2){
                tempCommon = listNode1;
            }
            if (listNode1!=listNode2){
                return tempCommon;
            }
        }

        return tempCommon;



    }


    public ListNode getCommonListNode2(ListNode root1 , ListNode root2){

        int count1 = 0 ;
        int count2 = 0 ;
        ListNode head1 = root1;
        ListNode head2 = root2;
        while (head1!= null){
            count1++;
            head1 = head1.next;
        }

        while (head2!=null){
            count2++;
            head2 = head2.next;
        }

        if (count1 > count2){
            int start = count1 - count2;
            while (start >0) {
                root1 = root1.next;
                start--;
            }

            while (root1!= null && root2!=null){
                if (root1 == root2){
                    return root1;
                }else {
                    root1 = root1.next;
                    root2 = root2.next;
                }
            }
        }else if (count1 < count2){
            int start = count2 - count1;
            while (start >0) {
                root2 = root2.next;
                start--;
            }

            while (root1!= null && root2!=null){
                if (root1 == root2){
                    return root1;
                }else {
                    root1 = root1.next;
                    root2 = root2.next;
                }
            }
        }else {
            while (root1!= null && root2!=null){
                if (root1 == root2){
                    return root1;
                }else {
                    root1 = root1.next;
                    root2 = root2.next;
                }
            }
        }

        return null;

    }


    public static void main(String[] args){
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(2);
        root1.next.next = new ListNode(3);
        root1.next.next.next = new ListNode(6);
        root1.next.next.next.next =new ListNode(7);
        ListNode root2 = new ListNode(4);
        root2.next =  new ListNode(5);
        root2.next.next = root1.next.next.next;

//        ListNode root1 = new ListNode(1);
//        root1.next = new ListNode(2);
//        root1.next.next = new ListNode(3);
//        root1.next.next.next = new ListNode(6);
//        ListNode root2 = new ListNode(4);
//        root2.next =  new ListNode(5);
//        root2.next.next = root1.next.next.next;

//        ListNode root1 = new ListNode(1);
//        root1.next = new ListNode(2);
//        root1.next.next = new ListNode(3);
//        root1.next.next.next = new ListNode(6);
//        root1.next.next.next.next =new ListNode(7);
//        ListNode root2 = new ListNode(4);
//        root2.next =  new ListNode(5);
//
//        ListNode root1 = new ListNode(1);
//        root1.next = new ListNode(2);
//        root1.next.next = new ListNode(3);
//        root1.next.next.next = new ListNode(6);
//        root1.next.next.next.next =new ListNode(7);
//        ListNode root2 = root1.next.next.next;


        System.out.println(new Test52().getCommonListNode2(root1,root2).val);
    }
}
