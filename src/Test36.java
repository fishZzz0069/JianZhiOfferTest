import java.util.List;

public class Test36 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }



    public static class ListNode {
        int val;
        ListNode left;
        ListNode right;
        ListNode(int x) { val = x; }



    }

    public ListNode BinarySearch2List(TreeNode root){
        if (root == null)
            return null;


        ListNode res = null;
        return bst2Dl(root,res);



    }

    private ListNode bst2Dl(TreeNode root,ListNode res) {

        if (root.left!=null){
            res = bst2Dl(root.left,res);

        }
        if (res == null) {
            res = new ListNode(root.val);
        }else {
            ListNode listNode = new ListNode(root.val);
            res.right = listNode;
            res.right.left = res;
            res = res.right;
        }

        if (root.right!=null){
            res = bst2Dl(root.right,res);
        }

        return res;

    }


    class Solution {
        TreeNode head = null;
        TreeNode realHead = null;
        public TreeNode Convert(TreeNode pRootOfTree) {
            ConvertSub(pRootOfTree);
            return realHead;
        }

        private void ConvertSub(TreeNode pRootOfTree) {
            if(pRootOfTree==null) return;
            ConvertSub(pRootOfTree.left);
            if (head == null) {
                head = pRootOfTree;
                realHead = pRootOfTree;
            } else {
                head.right = pRootOfTree;
                pRootOfTree.left = head;
                head = pRootOfTree;
            }
            ConvertSub(pRootOfTree.right);
        }
    }

    public static void main(String[] args){
        TreeNode t1= new TreeNode(3);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(5);
        Test36 test36 = new Test36();
        test36.BinarySearch2List(t1);
        System.out.println(test36);

    }
}
