public class Test533 {


    public int getCorrespondResult(int[] num){

        if (num == null){
            return -1;
        }
        int p1 = 0;
        int p2 = num.length-1;
        while (p1<=p2){
            int mid = p1 + (p2 -p1) / 2;
            if (num[mid] == mid){
                return mid;
            }else {
                if (mid + 1 <= num.length -1 && num[mid] < mid) {
                    p1 = mid + 1;
                }else if (mid-1 >=0 && num[mid] > mid){
                    p2 = mid - 1;
                }
            }


            return -1;




        }
        return -1;
    }


    public static void main(String[] args){
//        System.out.println(new Test533().getCorrespondResult(new int[]{-3,-1,1,3,5}));
//        System.out.println(new Test533().getCorrespondResult(new int[]{-3,-1,1,5}));
//        System.out.println(new Test533().getCorrespondResult(new int[]{0,5}));
//        System.out.println(new Test533().getCorrespondResult(new int[]{-3,1}));
//        System.out.println(new Test533().getCorrespondResult(new int[]{-3,-1,1,3}));
        System.out.println(new Test533().getCorrespondResult(new int[]{-3}));
    }
}
