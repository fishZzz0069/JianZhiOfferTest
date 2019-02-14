package Improved;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.Stack;

public class Solution33 {

    public boolean VerifySquenceOfBST(int [] sequence) {


        if (sequence == null || sequence.length ==0){
            return false;
        }

        int length = sequence.length;
        int root = sequence[length-1];

        int endl = 0;
        for (int i = 0 ; i < length-1 ; i++){
            if (sequence[i] > root){
                break;
            }
            endl = i;
        }

        int startR = endl+1;
        for (int j = endl+1; j < length-1 ; j++){
            if (sequence[j] < root){
                return false;
            }
        }

        boolean left = true;
        if (endl > 0 ){
            int[] leftSequence = new int[endl+1];
            for (int i = 0 ; i <= endl ;i++ ){
                leftSequence[i] = sequence[i];
            }
            left = VerifySquenceOfBST(leftSequence);
        }


        boolean rigtht =true;
        if ( startR < length-1 ){
            int[] rigthtSequence = new int[length-startR];
            for (int i = 0 ; i < endl ;i++ ){
                rigthtSequence[i] = sequence[startR+i];
            }
            rigtht = VerifySquenceOfBST(rigthtSequence);

        }

        return left&&rigtht;

    }

    public static void main(String args[]){
        int[] test = new int[]{7,4,6,5};
        int[] test2 = new int[]{5,7,6,9,11,18};
        System.out.println(new Solution33().VerifySquenceOfBST(test2));
    }
}
