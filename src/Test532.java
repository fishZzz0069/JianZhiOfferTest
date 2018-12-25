public class Test532 {

    public int getLostNum(int[] num){

        int p1 = 0 ;
        int p2 = num.length-1;
        while (p1<=p2){

            int mid = p1 + (p2-p1)/2;
            if (num[mid] == mid){
                p1 = mid + 1;
            }else if (mid-1 >= 0 && num[mid] != mid && num[mid-1]!= mid-1){
                p2 = mid - 1;
            }else {
                return mid;
            }



        }


        return -1;
    }


    public static void main(String[] args){
        System.out.println(new Test532().getLostNum(new int[]{0,1,2,3,5,6,7}));
        System.out.println(new Test532().getLostNum(new int[]{0}));
        System.out.println(new Test532().getLostNum(new int[]{1,2,3,4,5,6,7}));
        System.out.println(new Test532().getLostNum(new int[]{0,1,2,3,5}));

    }
}
