import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Test32 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /*
    层序遍历树
     */
    public void printTree(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);


        while (!queue.isEmpty()){
            TreeNode toBePrinted = queue.remove();
            System.out.print(toBePrinted.val);



            if (toBePrinted.left!=null){
                queue.add(toBePrinted.left);

            }
            if (toBePrinted.right!=null){
                queue.add(toBePrinted.right);
            }





        }
    }

    /*
    分行层序遍历树
     */
    public void printTree2(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        int levelNum = 1 ;
        while (!queue.isEmpty()){
            TreeNode toBePrinted = queue.remove();
            System.out.print(toBePrinted.val);
            levelNum --;


            if (toBePrinted.left!=null){
                queue.add(toBePrinted.left);

            }
            if (toBePrinted.right!=null){
                queue.add(toBePrinted.right);
            }

            if (levelNum == 0 ) {
                System.out.println();
                levelNum = queue.size();
            }



        }


    }

    /*
    之字型遍历树
     */

    public void printTree3(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()||!stack2.isEmpty()){

            while (!stack1.isEmpty()){
                TreeNode toBeprint = stack1.pop();
                System.out.print(toBeprint.val);
                if (toBeprint.left!=null){
                    stack2.push(toBeprint.left);
                }
                if (toBeprint.right!=null){
                    stack2.push(toBeprint.right);
                }

                if(stack1.isEmpty()){
                    System.out.println();
                }
            }

            while (!stack2.isEmpty()){
                TreeNode toBeprint = stack2.pop();
                System.out.print(toBeprint.val);
                if (toBeprint.right!=null){
                    stack1.push(toBeprint.right);
                }
                if (toBeprint.left!=null){
                    stack1.push(toBeprint.left);
                }
                if(stack2.isEmpty()){
                    System.out.println();
                }
            }
        }

    }


    public static void main(String[] args){
        TreeNode t1= new TreeNode(3);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(5);

        t1.left.left = new TreeNode(6);
        t1.left.right = new TreeNode(7);
        t1.right.left = new TreeNode(8);
        t1.right.right = new TreeNode(9);

        new Test32().printTree3(t1);
    }
}
