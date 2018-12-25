import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Test42 {

    public int getMaxSubSum(int[] array){


        int curSum = 0;

        int greatestSum=0x80000000;
        for (int i = 0; i < array.length; i++) {
            if (array.length==0 || array==null) {
                return 0;
            }
            if (curSum<=0) {
                curSum=array[i]; //记录当前最大值
            }else {
                curSum+=array[i]; //当array[i]为正数时，加上之前的最大值并更新最大值。
            }
            if (curSum>greatestSum) {
                greatestSum=curSum;
            }
        }
        return greatestSum;

    }

    //Dynamic plan
    public int getMaxSubSum2(int[] num){

        int[] curSum = new int[num.length];
        curSum[0] = num[0];
        for (int i = 1 ; i < num.length ; i ++){
            if (curSum[i-1] > 0){
                curSum[i] = curSum[i-1] + num[i];
            }else {
                curSum[i] = num[i];
            }


        }
        int maxSum = 0;
        for (int i = 0 ; i < num.length - 1 ; i++){
            if (curSum[i] > curSum[i+1]){
                maxSum = curSum[i];
            }else {
                maxSum = curSum[i+1];
            }


        }

        return maxSum;



    }



    public static void main(String[] args){
        System.out.println(new Test42().getMaxSubSum2(new int[]{1,-2,3,10,-4,7,2,-5}));
        System.out.println(new Test42().getMaxSubSum2(new int[]{-4,-5}));
    }
}
