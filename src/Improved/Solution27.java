package Improved;

import java.util.Stack;

public class Solution27 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void Mirror(TreeNode root) {

        if (root == null ){
            return;
        }

        if (root.left == null && root.right == null){
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.right!= null){
            Mirror(root.right);
        }

        if (root.left!=null){
            Mirror(root.left);
        }


    }

    //非递归版本
    public void Mirror2(TreeNode root) {

        if (root == null ){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();

            if (treeNode.left == null && treeNode.right == null){
                continue;
            }
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;


            if (treeNode.right!= null){
                stack.push(treeNode.right);
            }

            if (treeNode.left!=null){
                stack.push(treeNode.left);
            }

        }







    }
}
