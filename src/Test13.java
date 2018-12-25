public class Test13 {
    /**
     机器人的运动范围
     */

    public int countPathNum(char[] martrix,int rows,int cols,int ceil){
        boolean[] visited = new boolean[rows*cols];
        int count = 0;
        for (int i = 0 ; i < rows ; i++){
            for (int j = 0 ; j < cols ; j++){
                count = helper(martrix,rows,cols,i,j,ceil,count,visited);
            }
        }



        return count;
    }

    private int helper(char[] martrix,int rows,int cols, int i, int j, int ceil, int count,boolean[] visited) {

       if (i>=0 && j>=0 && i<rows && j<cols && check(i,j,ceil) == true && !visited[i*cols+j]){

           visited[i*cols+j] = true;

           count = 1 + helper(martrix,rows,cols,i,j+1,ceil,count,visited)
                   + helper(martrix,rows,cols,i,j-1,ceil,count,visited)
           +helper(martrix,rows,cols,i+1,j,ceil,count,visited)
           +helper(martrix,rows,cols,i-1,j,ceil,count,visited);

       }

       return count;



    }

    private boolean check(int i, int j, int ceil) {

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

        if (sumCol+sumRow <= ceil){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args){
        char[] test = new char[]{'a','b','c','d'};
        System.out.print(new Test13().countPathNum(test,2,2,0));
    }
}
