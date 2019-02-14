package Improved;

public class Solution14 {

    private int getMax(int n){
        if ( n < 2 )
            return 0;
        if ( n == 2)
            return 1;
        if ( n == 3)
            return 2;

        int[] products = new int[n+1];

        products[0] = 0;
        products[1] = 0;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i <= n ; i ++){
            products[i] = 0;
            for (int j =1 ;j <= i/2 ; j++){
                int temp = products[j] * products[i-j];
                if (temp > products[i]){
                    products[i] = temp;
                }
            }


        }


        return products[n];


    }


    public static void main(String[] args){


        System.out.print(new Solution14().getMax(4));
        System.out.print(new Solution14().getMax(8));
    }

}
