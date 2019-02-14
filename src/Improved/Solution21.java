package Improved;

public class Solution21 {

    public void reOrderArray(int [] array) {

        int pBegin = 0 ;


        while (pBegin < array.length){

            while (pBegin < array.length && funcpBegin(array[pBegin])){
                pBegin++;
            }
            int pEnd = pBegin + 1;

            while (pEnd < array.length && funcpEnd(array[pEnd])){
                pEnd++;
            }

            if (pEnd<array.length){
                int temp = array[pEnd];
                for (int pEnd2 = pEnd-1 ; pEnd2>=pBegin ; pEnd2--){
                    array[pEnd2+1] = array[pEnd2];
                }
                array[pBegin] = temp;
            }else {
                break;
            }
        }
    }

    private boolean funcpBegin(int num){
        if (num%2 == 0){
            return false;
        }
        return true;
    }


    private boolean funcpEnd(int num){
        if (num%2 != 0){
            return false;
        }
        return true;
    }



}
