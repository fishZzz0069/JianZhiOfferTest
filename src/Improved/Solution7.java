package Improved;

import apple.laf.JRSUIUtils;

public class Solution7 {


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length != in.length){
            return null;
        }

        TreeNode res = rebuild(0 ,pre.length-1,0,in.length-1,pre,in);

        return res;

    }

    private TreeNode rebuild(int startPre, int endPre, int startIn,int endIn, int[] pre, int[] in) {

        if (startPre>endPre || startIn>endIn){
            return null;
        }
        int root = pre[startPre];
        int locateIn = locate(root,in,startIn,endIn);
        if(locateIn == -1) //在中序数组中没有找到跟节点，则返回空
            return null;
        if (locateIn <=startIn && locateIn >= endIn){
            return new TreeNode(in[locateIn]);
        }

        TreeNode res = new TreeNode(root);
        res.left = rebuild(startPre+1,startPre+locateIn-startIn,startIn,locateIn-1,pre,in);
        res.right = rebuild(startPre+locateIn-startIn+1,endPre,locateIn+1,endIn,pre,in);
        return res;



    }

    //找到根节点在中序数组中的位置，根节点之前的是左子树的中序数组，根节点之后的是右子树的中序数组2
    private int locate(int root,int[] in,int startIn,int endIn)
    {
        for (int i = startIn; i <= endIn; i++)
        {
            if(root == in[i])
                return i;
        }
        return -1;
    }


    public static void main(String[] args){

        System.out.print((new Solution7().reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6})));


    }

}
