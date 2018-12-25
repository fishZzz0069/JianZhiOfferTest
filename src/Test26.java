public class Test26 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // Write your code here
        if (s == null) {
            return t == null;
        }

        if (s.val == t.val && isSametree(s, t)){
            return true;
        }

        return isSubtree(s.left, t) | isSubtree(s.right, t);
    }

    private boolean isSametree(TreeNode s, TreeNode t) {
        if (s == null){
            return t == null;
        }
        if (t == null){
            return false;
        }

        if (s.val != t.val){
            return false;
        }

        return isSametree(s.left, t.left) & isSametree(s.right, t.right);
    }

     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public static void main(String[] args){
        TreeNode t1= new TreeNode(3);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(5);

       t1.left.left = new TreeNode(1);
       t1.left.right = new TreeNode(2);
      t1.left.left.left = new TreeNode(0);

      TreeNode t2= new TreeNode(4);
      t2.left = new TreeNode(1);
      t2.right = new TreeNode(2);
      //t2.left.left = new TreeNode(1);
        System.out.println(new Test26().isSubtree(t1,t2));
  }


}
