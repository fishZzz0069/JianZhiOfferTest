import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Test63 {


    public int getMaxDiff(int[] num){

        if (num==null) {
            throw new IllegalArgumentException("num cant be null");

        }



        int[] min =  new int[num.length];
        min[0] = num[0];
        for (int i = 1 ;i <num.length-1 ;i++){
            if (num[i] < min[i-1]){
                min[i] = num[i];
            }else {
                min[i] = min[i-1];
            }
        }
        int maxDiff = num[1] - min[0];
        for (int i = 2 ; i<=num.length-1 ; i++){
            int temp = num[i] - min[i-1];
            if (temp >= maxDiff){
                maxDiff = temp;
            }
        }

        if (num[0] - min[0] > maxDiff){
            maxDiff = 0;
        }

        return maxDiff;
    }


    public static void main(String[] args){

        System.out.println(new Test63().getMaxDiff(new int[]{9,11,8,5,7,12,16,14}));
        System.out.println(new Test63().getMaxDiff(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(new Test63().getMaxDiff(new int[]{9,11}));
        System.out.println(new Test63().getMaxDiff(new int[]{11,10,9,8,7}));
        System.out.println(new Test63().getMaxDiff(null));

    }



}
