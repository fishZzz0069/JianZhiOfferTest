import java.util.ArrayList;

public class Test37 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public StringBuilder serialize(TreeNode root, StringBuilder res){

        if (root == null)
        {
            res.append("$,");
            return res;
        }


        if (root!=null)
            res.append(root.val + ",");




        serialize(root.left,res);


        serialize(root.right,res);


        return res;

    }



    public int index = -1;
    public TreeNode unSerialize(String  sb){
        index ++;
        int n =  sb.length();
        if (index >= n){
            return null;

        }

        String[] str = sb.split(",");
        TreeNode treeNode = null;
        if (!str[index].equals("$")){
            treeNode = new TreeNode(Integer.valueOf(str[index]));
            treeNode.left = unSerialize(sb);
            treeNode.right = unSerialize(sb);
        }

        return treeNode;
    }

    public static void main(String[] args){
        TreeNode t1= new TreeNode(3);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(4);
        t1.right = new TreeNode(5);

        StringBuilder res = new StringBuilder();


        String str = new Test37().serialize(t1,res).toString();
        System.out.println(str);

        System.out.println(new Test37().unSerialize(str).right);
    }
}
