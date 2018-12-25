public class Test57 {

    public void printPairNumEquals(int[] numms , int target){

        if (numms == null){
            System.out.println("no exist");
        }
        int before = 0;
        int behand = numms.length - 1 ;

        while (before < behand){
            int temp = numms[before] + numms[behand];
            if ( temp == target){
                System.out.println(numms[before] + " " + numms[behand]);
                break;
            }else if (temp < target){
                before++;
            }else {
                behand--;
            }


        }





    }



    public void findAllSequenceEquals(int[] nums,int target){
        int start = 0 ;
        int behand = 1;

        while ( behand<=nums.length-1 && start < behand){
            int temp = 0;
            for (int i = start ; i<=behand ; i++){
                temp += nums[i];
            }
            if (temp == target){
                System.out.println("from:" + (start+1) + "to:" + (behand+1));
                behand++;
            }else if (temp<target){
                behand++;
            }else {
                start++;
            }


        }



    }

    public static void main(String[] args){
//        new Test57().printPairNumEquals(new int[]{1,2,3,6,7,8,10},12);
//        new Test57().printPairNumEquals(new int[]{1,2,3,6,7,8,10},19);
        new Test57().findAllSequenceEquals(new int[]{1,2,3,4,5,6,7,8,9,10},15000);
        new Test57().findAllSequenceEquals(new int[]{1,2,3,4,5,6,7,8,9,10},3);
        new Test57().findAllSequenceEquals(new int[]{1,2,3,4,5,6,7,8,9,10},15);

    }



}
