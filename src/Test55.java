import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Test55 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int getLongestPath(TreeNode root , int path){

          if ( root.left!=null && root.right!=null ){

              return Math.max(getLongestPath(root.left,path),getLongestPath(root.right,path)) + 1;
          }else if (root.left !=null){
              return getLongestPath(root.left,path) + 1;
          }else if (root.right!=null){
              return getLongestPath(root.right,path) + 1;
          }else {
              return 1+path;
          }



    }

    private int getResult(TreeNode root){
        if (root == null){
            return 0;
        }

        return getLongestPath(root,0);
    }


    public static void main(String[] args){
        TreeNode t1= new TreeNode(3);
//        t1.left = new TreeNode(4);
//        t1.right = new TreeNode(5);
//
//        t1.left.left = new TreeNode(1);
//        t1.left.right = new TreeNode(2);
//        t1.left.right.left = new TreeNode(2);
        System.out.println(new Test55().getResult(t1));
    }
}
