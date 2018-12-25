import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
class Test5 {
    public ArrayList<Integer> printLinkedList( ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();


        ListNode pNode=listNode;

        if(pNode!=null){
            if(pNode.next!=null){
                list=printLinkedList(pNode.next);
            }
            list.add(pNode.data);

        }

        return list;
      }

      public static void main(String[] args){

          int[] nums = {1, 2, 3, 4, 5};
          ListNode head = new ListNode(nums);



        ArrayList<Integer> res = new Test5().printLinkedList(head);
        System.out.print(res);

      }


}

class ListNode{
     int data;
     ListNode next = null;

     ListNode(int data){
         this.data = data;
     }

    // 根据n个元素的数组arr创建一个链表
    // 使用arr为参数，创建另外一个ListNode的构造函数
    public ListNode (int[] arr){

        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.data = arr[0];
        ListNode curNode = this;
        for(int i = 1 ; i < arr.length ; i ++){
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    // 返回以当前ListNode为头结点的链表信息字符串
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder("");
        ListNode curNode = this;
        while(curNode != null){
            s.append(Integer.toString(curNode.data));
            s.append(" -> ");
            curNode = curNode.next;
        }
        s.append("NULL");
        return s.toString();
    }

}
