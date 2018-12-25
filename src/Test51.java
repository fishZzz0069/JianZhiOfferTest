import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Test51 {

    public int getRNumsPair(int[] nums){


        if (nums == null){
            return 0;
        }


        int res = 0;
        int n = nums.length;

        int[] copy = new int[n];
        res = getPNumsHelper(nums,copy,0,n-1);

        return res;


    }


    private int getPNumsHelper(int[] nums ,int[] copy, int low , int high) {

        int middle = low + (high - low)/2;

        if (low >= high){
            return 0;
        }


        int count = 0;





        int leftCount = getPNumsHelper(nums ,copy, low , middle);
        int rightCount = getPNumsHelper(nums ,copy,middle +1 , high);
        //count = merge(left , middle , high ,nums);

        int i = middle;
        int j = high;
        int loccopy = high;
        System.out.println("locCpoy1:" + loccopy);
        while (j >= middle+1 && low <=i) {
            if (nums[i] > nums[j]) {
                count += j - (middle + 1) + 1 ;
                copy[loccopy--] = nums[i--];
            }else if (nums[low] <= nums[high]){
                copy[loccopy--] = nums[j--];
            }



        }

        System.out.println("locCpoy2:" + loccopy);
        for(;i>=low;i--)
        {
            copy[loccopy--]=nums[i];
        }

        for(;j>middle;j--)
        {
            copy[loccopy--]=nums[j];
        }
        System.out.println("high"+ high +"low:"+low );
        for(int s=low;s<=high;s++)
        {
            nums[s] = copy[s];
        }



        return count + leftCount + rightCount;

    }

    private int merge(int left, int middle, int high, int[] nums) {
        int count = 0;
        if (left >= high){
            return 0;
        }

//        while (high >= middle+1 || left <=middle) {
//            if (nums[left] > nums[high]) {
//                count += high - (middle + 1) + 1 ;
//                left++;
//            }else if (nums[left] <= nums[high]){
//                high --;
//            }
//
//
//
//        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(new Test51().getRNumsPair(new int[]{7,5,6,4}));
    }


}
