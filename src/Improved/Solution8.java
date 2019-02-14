package Improved;

public class Solution8 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }


    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode res = null;
        if (pNode.right != null){
            res = pNode.right;
            while (res.left != null){
                res = res.left;
            }
            return res;
        }else{


            /*
            要注意节点为空的情况
             */
                while (pNode.next != null) {
                    if (pNode.next.left == pNode) {
                        res = pNode.next;
                        break;
                    }else {
                    pNode = pNode.next;
                    }

                }

                return res;
            }





    }
}
