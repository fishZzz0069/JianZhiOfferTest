public class Test7 {



    public TreeNode reConstructBinaryTree(int [] pre,int [] in)
        {
            if(pre == null || in == null || pre.length != in.length )//如果先序或者中序数组有一个为空的话，就无法建树，返回为空
                return null;
            else
            {
                return reBulidTree(pre,0,pre.length-1,in,0,in.length-1);
            }
        }
        private TreeNode reBulidTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn)
        {
            if(startPre > endPre || startIn > endIn)//先对传的参数进行检查判断
                return null;
            int root = pre[startPre];//数组的开始位置的元素是跟元素
            int locateRoot = locate(root,in,startIn,endIn);//得到根节点在中序数组中的位置 左子树的中序和右子树的中序以根节点位置为界
            if(locateRoot == -1) //在中序数组中没有找到跟节点，则返回空
                return null;
            TreeNode treeRoot = new TreeNode(root);//创建树根节点
            treeRoot.leftNode = reBulidTree(pre,startPre + 1,startPre + locateRoot - startIn,in,startIn,locateRoot-1);//递归构建左子树
            treeRoot.rightNode = reBulidTree(pre,startPre+locateRoot-startIn+1,endPre,in,locateRoot+1,endIn);//递归构建右子树
            return treeRoot;
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
       System.out.print(String.valueOf(new Test7().reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6})));
    }




    class TreeNode{

        int data;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }

        public TreeNode(int data){
            super();
            this.data = data;
        }




    }
}
