package Improved;

public class Solution13 {

    public int movingCount(int threshold, int rows, int cols)
    {

        boolean[] visited = new boolean[rows*cols];
        return movingCountHelper(threshold,0,0,visited,rows,cols);

    }


    int count = 0;
//    private int movingCountHelper(int threshold, int i, int j,boolean[] visited,int rows,int cols) {
//        if (i<0 || i>=rows || j<0 || j>=cols || visited[i*cols+j]==true || !judgeIllegal(i,j,threshold))
//            return 0;
//
//        visited[i*cols+j] = true;
//        return  1 + movingCountHelper(threshold,i+1,j,visited,rows,cols)
//                + movingCountHelper(threshold,i,j+1,visited,rows,cols)
//                + movingCountHelper(threshold,i-1,j,visited,rows,cols)
//                + movingCountHelper(threshold,i,j-1,visited,rows,cols);
//
//
//
//    }

    private int movingCountHelper(int threshold, int i, int j,boolean[] visited,int rows,int cols) {

        if (i<0 || i>=rows || j<0 || j>=cols || visited[i*cols+j]==true || !judgeIllegal(i,j,threshold)){
            return 0;
        }else {
            visited[i*cols+j] = true;
            count =  1 + movingCountHelper(threshold,i+1,j,visited,rows,cols)
                    + movingCountHelper(threshold,i,j+1,visited,rows,cols)
                    + movingCountHelper(threshold,i-1,j,visited,rows,cols)
                    + movingCountHelper(threshold,i,j-1,visited,rows,cols);
        }
         return count;




    }

     private boolean judgeIllegal(int i , int j , int threshold){

        int sumRow = 0;
        int sumCol = 0;
        while (i > 0){
             sumRow += i%10;
             i /= 10;
         }
         while (j >0){
             sumCol += j % 10;
             j /= 10;
         }

         if (sumCol+sumRow <= threshold){
             return true;
         }else {
             return false;
         }
     }

    public static void main(String[] args){
        char[] test = new char[]{'a','b','c','d'};
        System.out.print(new Solution13().movingCount(5,10,10));
    }
}
