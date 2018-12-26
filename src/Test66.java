public class Test66 {
    public int[] solution(int[] nums){

        int[] c = new int[nums.length];

        for (int s =0 ; s<nums.length ;s ++){
            c[s] = 1;
        }
        for (int i = 1 ; i < nums.length ; i++){
            for (int j = 0 ; j < i; j ++){
                c[i] *= nums[j] ;
            }
        }

        int[] d = new int[nums.length];
        for (int e =0 ; e<nums.length ;e ++){
            d[e] = 1;
        }
        for (int k = 0 ; k < nums.length-1 ; k++){
            for (int m = k+1 ; m < nums.length ; m++){
                d[k] *= nums[m];
            }
        }

        int[] res = new int[nums.length];
        for (int i = 0 ; i<nums.length ;i++){
            res[i] = c[i] * d[i];
            System.out.println(res[i]);
        }



        return res;



    }


    public static void main(String[] args){
        System.out.println(new Test66().solution(new int[]{1,2,3,4,5}));
    }
}
