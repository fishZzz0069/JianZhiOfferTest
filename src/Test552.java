public class Test552 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root){

        if (root == null)
            return false;

        int left = isBalancedDepth(root.left, 0);

        int right = isBalancedDepth(root.right, 0);

        int diff = right-left;

        if (diff>1||diff<-1)
            return false;

        return true;

    }


    private int isBalancedDepth(TreeNode treeNode,int depth){
        if (treeNode==null)
            return 0;


        int left = 1+isBalancedDepth(treeNode.left,depth);
        int right = 1+isBalancedDepth(treeNode.right,depth);

        return Math.max(left,right);

    }

    public static void main(String[] args){
        TreeNode t1= new TreeNode(3);
//        t1.left = new TreeNode(4);
//        t1.right = new TreeNode(5);
//
//        t1.left.left = new TreeNode(1);
//        t1.left.left.left = new TreeNode(7);
        System.out.println(new Test552().isBalanced(t1));
    }


}
