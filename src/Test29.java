import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;

public class Test29 {

    public ArrayList<Integer> printMatrix(int[][] matrix){

        int rows = matrix.length;
        int cols = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int time = 0;
        while (rows > i*2 && cols > j*2){

            printCore(i,j,matrix ,rows ,cols,res,time);
            i++;
            j++;
            time ++;
        }

        return res;


        }

    private  void printCore(int i ,int j , int[][] matrxie , int rows , int cols, ArrayList<Integer> list ,int  time){

        cols = cols -time;
        rows = rows - time;
        //左到右
        while (j < cols){
            list.add(matrxie[i][j]);
            j++;
        }
        j--;
        i++;

        //右到下
        while (i < rows){
            list.add(matrxie[i][j]);
            i++;
        }
        i--;
        j--;

        //下到左
        while (j>=time && time+1 < rows){
            list.add(matrxie[i][j]);
            j--;
        }
        j++;
        i--;


        //左到上
        while (i > time && rows >=3 && cols>=2){
            list.add(matrxie[i][j]);
            i--;
        }
        i++;
        j++;


    }

    public static void main(String[] args){

        int[ ] [ ] arr={{1,2,3},{4,5,6},{7,8,9}};

        int[ ] [ ] arr2={{1,2,3}};

        int[ ] [ ] arr3={{1},{4},{7}};

        int[ ] [ ] arr4={{1}};

        int[ ] [ ] arr5={{1,2,3,13},{4,5,6,15},{7,8,9,16}};
        ArrayList<Integer> res = new Test29().printMatrix(arr5);


        for (int i = 0 ; i < res.size() ; i++){
            System.out.println(res.get(i));
        }


    }
}
