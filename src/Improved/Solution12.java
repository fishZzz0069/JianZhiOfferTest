package Improved;

public class Solution12 {


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {

        if (cols<=0||rows<=0||matrix==null){
            return false;
        }

        boolean[] visited = new boolean[cols*rows];

        for (int i=0; i < rows ; i++){

            for (int j=0;j < cols ; j++){
                if(hasPathHelper(matrix,rows,cols,str,i,j,0,visited)){
                    return true;
                }
            }


        }

        return false;


    }

    private boolean hasPathHelper(char[] matrix, int rows, int cols, char[] str, int i, int j, int index, boolean[] visited) {

        if (i<0 || j<0 || i>=rows||j>=cols || matrix[i*cols+j]!=str[index]||visited[i*cols+j]==true)
            return false;

       if (index == str.length-1 )
           return true;


        visited[cols*i+j] = true;

        if(hasPathHelper(matrix,rows,cols,str,i+1,j,index+1,visited)||
                hasPathHelper(matrix,rows,cols,str,i,j+1,index+1,visited)||
                hasPathHelper(matrix,rows,cols,str,i-1,j,index+1,visited)||
                hasPathHelper(matrix,rows,cols,str,i,j-1,index+1,visited)){
                return true;

        }


        visited[cols*i+j] = false;

        return false;

    }


    public static void main(String[] args){
        char[] test = new char[]{'A','B','C','E','S','F','C','S','A','D','E','E'};
        char[] testStr = new char[]{'S','E','E'};
        System.out.print(new Solution12().hasPath(test,3,4,testStr));

    }



}
