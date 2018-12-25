public class Test33 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean isAfterTraverse(int[] num){

        if (num.length == 0 )
            return false;

        int n = num.length-1 ;

        return judge(num,0,n);




    }

    private boolean judge(int[] num, int i, int n) {
        if (i >=n )
            return true;
        int j = n - 1;
        while (j>i&&num[j]>num[n])
            j--;

        for (int k = i ; k < j ; k++){
            if (num[k] > num[n])
                return false;
        }

        return judge(num,j,n-1)&&judge(num,i,j);

    }

    public static void main(String[] args){
        int[] test = new int[]{7,4,6,5};
        System.out.println(new Test33().isAfterTraverse(test));
    }
}
