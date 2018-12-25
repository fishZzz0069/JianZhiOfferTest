import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {


    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private ArrayList<List<String>> res;

    public List<List<String>> getResult(int n){
        res = new ArrayList<List<String>>();
        col =  new boolean[n];
        dia1 = new boolean[ 2*n - 1 ];
        dia2 = new boolean[ 2*n - 1 ];
        LinkedList<Integer> row =   new LinkedList<>();


        putQueens(n,0,row);

        return res;






    }

    private void putQueens(int n, int index, LinkedList<Integer> row) {

        if ( n == index ){
            res.add(generateBoard(n,row));
            return;
        }

        //i represents col
        for (int i = 0 ; i < n ; i++){
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]){
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueens(n,index+1,row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();



            }
        }

        return;

    }

    public List<String> generateBoard(int n , LinkedList<Integer> row){
        assert row.size() == n;
        ArrayList<String> board = new ArrayList<String>();
        for (int i=0; i<n ; i++){
            char[] charArray = new char[n];
            Arrays.fill(charArray,'.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }

        return board;

    }



    public static void main(String[] args){
        System.out.println(new NQueens().getResult(4));



    }
}
