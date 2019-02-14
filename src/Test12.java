public class Test12 {

     public boolean hasPath(char[] martrix,int rows,int cols,char[] str){
         boolean[] visited = new boolean[rows*cols];
         for (int i = 0 ; i < rows ; i++){
             for (int j = 0 ; j < cols ; j++){
                 if (helper(martrix, rows,cols,0,i,j,str,visited))
                     return true;
             }
         }



         return false;
     }

    private boolean helper(char[] martrix,int rows,int cols, int index, int i, int j, char[] str,boolean[] visited) {

         if (i<0 || j<0 || i>=rows||j>=cols || martrix[i*cols+j]!=str[index]||visited[i*cols+j]==true)
             return false;

         if (index == str.length-1)
             return true;


         visited[i*cols+j] = true;
         if (helper(martrix,rows,cols,index+1,i+1,j,str,visited)
                 ||helper(martrix,rows,cols,index+1,i,j+1,str,visited)
                 ||helper(martrix,rows,cols,index+1,i-1,j,str,visited)
                 ||helper(martrix,rows,cols,index+1,i,j-1,str,visited)){
             return true;
         }
         visited[i*cols+j] = false;

         return false;


    }

    public static void main(String[] args){
         char[] test = new char[]{'A','B','C','E','S','F','C','S','A','D','E','E'};
         char[] testStr = new char[]{'A','B','C','C','E','D'};
         System.out.print(new Test12().hasPath(test,3,4,testStr));

    }


}
