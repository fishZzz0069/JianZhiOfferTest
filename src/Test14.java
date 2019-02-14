public class Test14 {

    public int getMax(int n){

        int[] product = new int[n+1];
        if ( n < 2 )
            return 0;
        if ( n == 2)
            return 1;
        if ( n == 3)
            return 2;

        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;


        for (int i = 4 ; i <= n ; i++){
            int max = 0;

            for (int j =1 ; j <=  i/2 ;j++){
                int res = product[j] * product[i-j];
                if (max < res)
                    max = res;
                product[i] = max;

            }


        }

        int max = 0;
        max = product[n];
        return max;


    }

    public static void main(String[] args){
        System.out.print(new Test14().getMax(8));
    }


}
