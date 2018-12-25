public class Test8 {

    public BinaryTreeNode getNextTreeNode(BinaryTreeNode node){

        if (node == null)
            return null;



        if (node.right == null){
            while (node.parent != null){
                if (node.parent.left == node){
                    return node.parent;
                }else{
                    node = node.parent;
                }
            }

            return null;
        }else {
            node = node.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }




    }

    class BinaryTreeNode {
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private BinaryTreeNode parent;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }


}



