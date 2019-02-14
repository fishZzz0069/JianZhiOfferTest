package Improved;

public class Solution4 {
    public boolean Find(int target, int [][] array) {


        /*
          判断二维数组是否可用
        */
        if(array==null||array.length==0||(array.length==1&&array[0].length==0))
        {
            return false;
        }

        int res = 0;
        int col = array[0].length-1;
        int row = array.length-1;
        int i = 0;
        int j = row;
        int temp = array[i][j];
        while(i<=row && j>=0){

            if(temp < target){
                if(i<row)
                {
                    i++;
                }else{
                    return false;
                }
            }else{
                if(j>0){
                    j--;
                }else{
                    return false;
                }
            }
            temp = array[i][j];
            if(temp == target){
                return true;
            }
        }

        return false;

    }
}
