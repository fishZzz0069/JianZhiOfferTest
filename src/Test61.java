public class Test61 {

    public boolean isContinus(int[] nums ,int length){
        for (int i = 0 ; i < nums.length ;i++){
            for (int j = 1 ; j < nums.length ;j++){
            if (nums[j] < nums[j-1]){
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
            }else if (nums[j] == nums[j-1]){
                return false;
            }
            }
        }

        int zero = 0;
        int dis = 0;
        for (int i = nums.length-1 ; i>=0 ;i--){
            if (nums[i] == 0){
                zero++;
            }else if (i>=1 && nums[i] - nums[i-1]!=1){

                dis += nums[i] - nums[i-1];

            }else if (i==0){
                if (nums[i+1]-nums[i] !=1){
                    dis += nums[i+1]-nums[i];
                }
            }
        }

        if (dis -zero <= 0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
       System.out.println(new Test61().isContinus(new int[]{1,1,2,3,0},5));


    }
}
