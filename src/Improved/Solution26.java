package Improved;


public class Solution26 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if(root2 == null || root1 == null ){
            return false;
        }




        if (root1.val == root2.val & HasSubtreeHelper(root1,root2)){
            return true;
        }

        return HasSubtree(root1.left,root2) || HasSubtree(root1.right, root2);

    }

    private boolean HasSubtreeHelper(TreeNode root1, TreeNode root2) {



        if (root1 == null) {
            return root2 == null;
        }


        if(root2 == null ){
            return true;
        }


        if (root1.val != root2.val){
            return false;
        }

        return HasSubtreeHelper(root1.right,root2.right) && HasSubtreeHelper(root1.left,root2.left);






    }

}
