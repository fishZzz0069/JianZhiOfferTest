public class Test28 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean isSymmertirc(TreeNode rootNode){
        if (rootNode == null ){
            return false;
        }


        return isSymmertircRecursive(rootNode.left,rootNode.right);




    }

    private boolean isSymmertircRecursive(TreeNode left, TreeNode right) {

        /*
        * 判断是否为叶子节点很重要，因为都为null的时候依旧会进入循环，会造成空指针异常
        *
        * */
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        if (left.val != right.val){
            return false;
        }else {
            return isSymmertircRecursive(left.left,right.right) && isSymmertircRecursive(left.right,right.left);
        }

    }
/*
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null ){
            return false;
        }

        if(left.val != right.val)
        {return false;}


        if( helper(left.right,right.left) && helper(left.left, right.right)){
            return true;
        }else{
            return false;
        }
**/

    public static void main(String[] args){
        TreeNode t1= new TreeNode(1);
//        t1.left = new TreeNode(2);
//        t1.right = new TreeNode(2);
//
//        t1.left.left = new TreeNode(3);
//        t1.left.right = new TreeNode(4);
//        t1.right.left = new TreeNode(4);
//        t1.right.right = new TreeNode(3);


        //t2.left.left = new TreeNode(1);
        System.out.println(new Test28().isSymmertirc(t1));
    }


    }
