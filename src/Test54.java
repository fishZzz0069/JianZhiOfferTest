import java.util.ArrayList;
import java.util.List;

public class Test54 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public ArrayList getMaxK(TreeNode root, ArrayList res){


        if (root.left!=null) {
            getMaxK(root.left, res);
        }
        res.add(root);
        if (root.right!=null){
            getMaxK(root.right,res);
        }

        return res;
    }

    private int getMaxkTreenodeValue(TreeNode root,int k){
        if (root == null || k <= 0 )
            return -1;


        ArrayList<TreeNode> res = new ArrayList<>();

        getMaxK(root,res);

        if (k > res.size()){
            return  -1;
        }


        return res.get(k-1).val;
    }


    public static void main(String[] args){

        TreeNode t1= new TreeNode(3);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(5);
        t1.left.left=new TreeNode(1);
        t1.right.left = new TreeNode(4);
        t1.right.right = new TreeNode(6);

        System.out.println(new Test54().getMaxkTreenodeValue(t1,3));
    }
}
