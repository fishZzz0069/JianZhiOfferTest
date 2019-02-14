package Improved;

public class Solution3 {

    /*
    *遍历整个数组：
    *  如果该位的数字不等于本该在的位置：
    *    去交换（正确位置）的数值已经存在在该位置，就说明此数字为重复数；
    *    否则与应该在的位置进行交换；
    *  如果该位的数字就是本该在的位置，进行下一轮循环；
    *
    *
    *  在遍历之前可以先判断数组中数字的合法性(大于0小于length)
    *
    *
    * */

    public int findDuplication(int[] nums) {


        int temp;
        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != i ) {

                if (nums[nums[i] ] == nums[i]) {

                    return nums[i];
                }


                temp = nums[i] ;
                nums[i] = nums[temp];
                nums[temp] = temp;


            }
        }
        return -1;


    }


    public int findD(int[] nums){
        int end = nums.length-1;
        int start = 0 ;
        int res = findDupilication2(nums,start,end);
        return res;
    }

    public int res = 0 ;
    public int findDupilication2(int[] nums,int start,int end){
        /*
         *如果采用递归实现，结果的保存一定不可以在递归函数体中初始化，每次重新会重新赋值造成错误！
         *
         *
         * */



            int middle = start + (end - start) / 2;
            int count = getCount(nums, start, middle);
            int dis = middle - start + 1;


            if (dis == 1) {
                if (count > 1) {
                    return start;
                }else {
                    return res;
                }
            }


            if (count > (middle - start) + 1) {
                res = findDupilication2(nums, start, middle);
            } else {
                res = findDupilication2(nums, start, middle);
                res = findDupilication2(nums, middle + 1, end);
            }


            return res;




    }

    private int getCount(int[] nums, int start, int end) {
        int count = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i]<=end && nums[i] >=start){
                count++;
            }
        }
        return count;

    }


    public static void main(String[] args){
        System.out.println(new Solution3().findD(new int[]{7,6,5,2,1,2,3,0}));
        System.out.println(new Solution3().findD(new int[]{2,3,5,4,3,2,6,7}));
        System.out.println(new Solution3().findD(new int[]{1,2,3,3,3}));

    }

}
