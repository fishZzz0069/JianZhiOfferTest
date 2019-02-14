import org.omg.CORBA.StringHolder;

import java.util.ArrayList;

public class Test62 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public int Josephuse(ListNode listnode , int n ){

        int start = 0;
        ListNode current = listnode;
        while (current.next != current){




            for (int i = start ; i <= start + n -1 -1 -1 ; i++){
                current = current.next;
            }
            current.next = current.next.next;


        }

        return current.val;


    }


    public static void main(String[] args){

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = head;
        System.out.println(new Test62().Josephuse(head,3));
    }



}
