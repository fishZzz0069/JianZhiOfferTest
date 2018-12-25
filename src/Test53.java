public class Test53 {


//    int res =  0 ;
//    public int getAppearenceTimesOfNum(int[] nums ,int target , int p2 , int p1){
//
//
//        int middle = p1 + (p2-p1)/2;
//
//        while (!flagstart || !flagend){
//
//            if (!flagstart){
//            if (nums[middle] == target && nums[middle - 1] != target){
//                start = middle;
//            }else if (nums[middle] == target && nums[middle - 1] == target){
//                start = getAppearenceTimesOfNum(nums,target,middle-1,p1);
//            }
//            flagstart = true;
//            }
//
//            if (!flagend) {
//                if (nums[middle] == target && nums[middle + 1] != target) {
//                    end = middle;
//                } else if (nums[middle] == target && nums[middle + 1] == target) {
//                    end = getAppearenceTimesOfNum(nums, target, p2, middle + 1);
//                }
//                flagend = true;
//            }
//
//
//
//
//        }
//        return res = end - start;
//
//
//
//    }

    int start;
    int end;
    int res;
    private int getResult(int[] nums, int target){

        if (nums == null)
            return 0;


        start = getFirstK(nums,target,0,nums.length-1) ;
        end = getLastKLoop(nums,target,0,nums.length-1) ;

        if (start == end && start!=-1)
            res = 1;
        else
            res = end - start;
        return  res ;
    }

    //递归只需要不断的开辟新空间找到该找的值或者到终止条件跳出循环即可
    private int getFirstK(int[] nums, int target, int p1, int p2) {

        int middle = p1 + (p2-p1)/2;

        if (p1>p2){
            return -1;
        }

        if (nums[middle] == target && nums[middle - 1] != target){
                return start = middle;
        }else if (nums[middle] == target && nums[middle - 1] == target){
                return start = getFirstK(nums,target,p1,middle-1);
        }else if (nums[middle] < target){
                return start = getFirstK(nums,target,middle+1,p2);
        }else{
                return start = getFirstK(nums,target,p1,middle-1);
        }


    }

    private int getLastK(int[] nums, int target, int p1, int p2) {
        int middle = p1 + (p2 - p1) / 2;

        if (p1>p2){
            return -1;
        }

        if (nums[middle] == target && nums[middle + 1] != target) {
                return end = middle;
        } else if (nums[middle] == target && nums[middle + 1] == target) {
                return end = getLastK(nums, target, middle + 1, p2);
        } else if (nums[middle] < target) {
                return end = getFirstK(nums, target, middle + 1, p2);
        } else {
                return end = getFirstK(nums, target, p1, middle - 1);
        }




    }

    // 循环写法
    public int getLastKLoop(int[] nums ,int target ,int p1, int p2){

        while (p1 <= p2){
            int mid = p1 + (p2 - p1 )/ 2;
            if (nums[mid] > target){
                p2 = mid-1 ;
            }else if ((nums[mid] < target)){
                p1 = mid +1;
            }else if (mid +1 < nums.length && nums[mid+1] == target){
                 p1 = mid+1;
            }else {
                return mid;
            }


        }

        return -1;

    }




    public static void main(String[] args){

        System.out.println(new Test53().getResult(new int[]{1,2,3,3,3,5},3));
        System.out.println(new Test53().getResult(new int[]{1,2,3,3,3,5},7));
        System.out.println(new Test53().getResult(new int[]{1,2,3,3,3,5},5));
        System.out.println(new Test53().getResult(null,5));

    }

}
