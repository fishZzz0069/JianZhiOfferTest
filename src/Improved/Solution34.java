package Improved;

import java.util.ArrayList;

public class Solution34 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> ress = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return ress;
        }


        return FinaPathHelper(root,target,ress,res);


    }

    private ArrayList<ArrayList<Integer>> FinaPathHelper(TreeNode root, int target, ArrayList<ArrayList<Integer>> ress,ArrayList res) {

        target = target - root.val;
        res.add(root.val);
       if (root.left == null && root.right == null && target == 0 ){
           ress.add(new ArrayList<>(res));
           res.remove(res.size()-1);
           return ress;
       }


       if (root.left!=null){
           ress = FinaPathHelper(root.left,target,ress,res);

       }

       if (root.right!=null){
           ress = FinaPathHelper(root.right,target,ress,res);

       }


       res.remove(res.size()-1);

       return ress;



    }


    public static void main(String[] args){
        TreeNode t1= new TreeNode(10);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(12);

        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(7);
        System.out.println(new Solution34().FindPath(t1,22));
    }
}
