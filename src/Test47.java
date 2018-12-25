public class Test47 {

    public int getMaxValue(int[][] values){
        int m = values.length ;
        int n = values[0].length ;


//        int[][] maxValue = new int[m][n];

//        for (int i = 0 ;i < m ;i++){
//
//
//            for (int j = 0 ; j < n ; j++){
//
//                if (j==0&&i==0){
//                    maxValue[0][0] = values[0][0];
//                } else if ( j-1< 0){
//                    maxValue[i][j] = maxValue[i-1][j] + values[i][j];
//                }else if ( i-1<0){
//                    maxValue[i][j] = maxValue[i][j-1] + values[i][j];
//                }else {
//                    if (maxValue[i-1][j] >= maxValue[i][j-1]){
//                        maxValue[i][j] = maxValue[i-1][j] + values[i][j];
//                    }else {
//                        maxValue[i][j] = maxValue[i][j-1] + values[i][j];
//                    }
//
//
//                }
//
//
//
//
//            }
//
//
//
//        }


        int[] maxValue = new int[n];
        for (int i = 0 ;i < m ;i++){


            for (int j = 0 ; j < n ; j++){

                if (j==0&&i==0){
                    maxValue[0] = values[0][0];
                } else if ( j-1< 0){
                    maxValue[j] = maxValue[j] + values[i][j];
                }else if ( i-1<0){
                    maxValue[j] = maxValue[j-1] + values[i][j];
                }else {
                    if (maxValue[j] >= maxValue[j-1]){
                        maxValue[j] = maxValue[j] + values[i][j];
                    }else {
                        maxValue[j] = maxValue[j-1] + values[i][j];
                    }


                }




            }



        }

        return maxValue[n-1];
    }

    public static void main(String[] args){

        System.out.println(new Test47().getMaxValue(new  int[][]{{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}}));
        System.out.println(new Test47().getMaxValue(new  int[][]{{1},{2},{3}}));
        System.out.println(new Test47().getMaxValue(new  int[][]{{1}}));
        System.out.println(new Test47().getMaxValue(new  int[][]{{1,10,3,8}}));

    }


}
