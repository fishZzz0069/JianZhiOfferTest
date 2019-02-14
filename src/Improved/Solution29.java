package Improved;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.ArrayList;

public class Solution29 {

    public int[] clockwisePrint(int[][] mat, int n, int m) {

        int startX = 0;
        int startY = 0;

        int[] res = new int[n*m];

        ArrayList<Integer> result = new ArrayList<>();
        while (startX*2<n && startY*2<m){
            clockwisePrinthelper(startX,startY,mat,n,m,result);
            startX++;
            startY++;
        }

        for (int i = 0; i < result.size() ;i++){
            res[i] = result.get(i);
        }

        return res;

    }

    private void clockwisePrinthelper(int startX, int startY, int[][] mat,int n, int m,ArrayList<Integer> res) {

        int endX = m - startX - 1;
        int endY = n - startY - 1;

        //从左往右
        for (int i = startX ; i <= endX; i++){
            res.add(mat[startX][i]);

        }

        if (startY < endY) {
            //从右往下
            for (int j = startY + 1; j <= endY; j++) {
                res.add(mat[j][endX]);

            }
        }

        if (startX < endX && startX < endY) {
            //从下往左
            for (int r = endX - 1; r >= startX; r--) {
                res.add(mat[endY][r]);

            }
        }

        if (startY < endY-1 && startX < endX) {
            //从左往上
            for (int c = endY - 1; c > startY; c--) {
                res.add(mat[c][startX]);

            }
        }
    }

    public static void main(String[] args){
        int[ ] [ ] arr={{98,30,17},{38,96,90},{17,0,50},{44,12,67},{12,79,43},{43,63,40},{19,93,48},};

        new Solution29().clockwisePrint(arr,7,3);


    }


}
