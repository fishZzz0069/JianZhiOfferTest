public class Test11 {

    public int findMin(int[] nums) {

       int index  = 0;
       int index2 = nums.length-1;
       int mid = index;
        while (nums[index] >= nums[index2]){

            if (index2 - index == 1){
             mid = index2;
             break;
           }

           mid = index + (index2-index)/2;


            if (nums[index] == nums[mid] && nums[mid] == nums[index2]){
                int result = nums[0];
                for (int i = 1 ; i < index2 ; i++){
                    if (nums[i] < result){
                        mid = i;
                        break;
                    }
                }
                break;
            }

            if (nums[mid]>=nums[index]){
               index = mid;
           }else if (nums[mid] <= nums[index2]){
               index2 = mid;
           }

       }

       return nums[mid];

    }

    public static void main(String[] args){

        int[] nums = new int[]{5,1,2,3,4};
        System.out.print(new Test11().findMin(nums));
    }



}
