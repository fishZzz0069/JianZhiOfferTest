package Improved;

import java.util.ArrayList;

public class Solution6 {


    public static class ListNode {
        int val;
        ListNode next = null;

               ListNode(int val) {
            this.val = val;
        }
    }

    /*
    通过递归不断进入下一链表节点，直到最后一个（此时为退出条件）
    然后将最后一个链表节点加入res，返回上一层状态
    将最新的res赋给这一状态下的res
    再将此时状态下的（前一个链表节点）值赋给res，继续返回上一层
    ....
    最后反向打印了链表（递归也可以换成栈来实现，本质上都是后进先出）


     */

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {


        ArrayList<Integer> res = new ArrayList<>();


        if (listNode == null)
            return null;

        res = getListFromEnd(res,listNode);
        return res;

    }

    private ArrayList<Integer> getListFromEnd(ArrayList<Integer> res, ListNode listNode) {
        if (listNode.next == null) {
            res.add(listNode.val);
            return res;
        }

        res = getListFromEnd(res,listNode.next);
        res.add(listNode.val);
        return res;
    }

    public static void main(String[] args){
        ListNode test = new ListNode(3);
        test.next = new ListNode(4);
        ListNode test2 = null;

        System.out.println(new Solution6().printListFromTailToHead(test2));


    }

}
