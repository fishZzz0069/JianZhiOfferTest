import java.util.ArrayList;

public class Test34 {

    public ArrayList<ArrayList> getAllSumPath(TreeNode root,int target){
        if (root == null)
            return null;


        ArrayList<ArrayList> ress = new ArrayList<>();
        ArrayList<TreeNode> res =new ArrayList<>();
        return getPaths(ress,root,res,target);



    }

    private ArrayList<ArrayList> getPaths(ArrayList<ArrayList> ress, TreeNode root , ArrayList res,int target) {

        target = target - root.val;
        res.add(root);
        if (root.left == null && root.right==null && target == 0){
            ress.add(new ArrayList<>(res));
        }




        if (root.left!=null)
            getPaths(ress,root.left,res,target);
        if (root.right!=null)
            getPaths(ress,root.right,res,target);

        res.remove(root);
        return ress;
    }

    public static void main(String[] args){
        TreeNode t1= new TreeNode(3);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(5);

        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(2);
        System.out.println(new Test34().getAllSumPath(t1,8).get(0).get(0));
    }


}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
