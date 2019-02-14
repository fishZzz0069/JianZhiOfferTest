package Improved;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Solution32 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue =  new ArrayDeque<>();
        queue.add(root);


        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            res.add(temp.val);
            if (temp.left != null){
               queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }

        }

        return res;

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null){
            return res;
        }

        Queue<TreeNode> queue =  new ArrayDeque<>();
        queue.add(pRoot);

        int levelNum = queue.size();
        ArrayList<Integer> tempList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            tempList.add(temp.val);
            levelNum --;

            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }

            if (levelNum == 0){
                res.add(new ArrayList<>(tempList));
                tempList.clear();
                levelNum = queue.size();

            }



        }

        return res;



    }


    public ArrayList<ArrayList<Integer> > ZPrint(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (pRoot == null){
            return res;
        }

        stack1.push(pRoot);
        while (!stack1.isEmpty()||!stack2.isEmpty()){
            ArrayList<Integer> templist = new ArrayList<>();
            if (stack1.isEmpty()){
                while (!stack2.isEmpty()){
                    TreeNode temp = stack2.pop();
                    templist.add(temp.val);
                    if (temp.right!=null){
                        stack1.push(temp.right);
                    }
                    if (temp.left!=null){
                        stack1.push(temp.left);
                    }
                }
                res.add(new ArrayList<>(templist));



            }else {
                while (!stack1.isEmpty()){
                    TreeNode temp = stack1.pop();
                    templist.add(temp.val);
                    if (temp.left!=null){
                        stack2.push(temp.left);
                    }
                    if (temp.right!=null){
                        stack2.push(temp.right);
                    }
                }

                res.add(new ArrayList<>(templist));

            }

        }
        return res;
    }


    public static void main(String[] args){
        TreeNode t1= new TreeNode(10);
        t1.left = new TreeNode(6);
        t1.right = new TreeNode(14);

        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(8);
        t1.right.left = new TreeNode(12);
        t1.right.right = new TreeNode(16);

        TreeNode t2 = null;

        new Solution32().Print(t1);
    }
}
