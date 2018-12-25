import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Random;

public class Test39 {

    Random random = new Random();
    public int getOverHalf(int[] num){




        int mid = num.length / 2;
        int start = 0;
        int end = num.length - 1 ;
        int index = partition(num,num.length,start,end);
        while (index != mid){

              if(index < mid){
                  index = partition(num,num.length,index+1,end);
              }else {

                  index = partition(num,num.length,start,index-1);
              }

        }

        return num[index];


    }

    private int partition(int[] num, int length, int start, int end) {
        int lt = start ;
        int rt = end + 1;
        int i = lt+1;
        while (i < rt){

            if (num[start] > num[i]){
                lt++;
                i++;
            }else if (num[start] < num[i]){
                rt--;
                swap(num,i,rt);

            }else if (num[start] == num[i]){
                i++;
            }

        }
        swap( num, start, lt );
        return lt;

    }

    private static int partition(Comparable[] arr, int l, int r){

        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for( int i = l + 1 ; i <= r ; i ++ )
            if( arr[i].compareTo(v) < 0 ){
                j ++;
                swap(arr, j, i);
            }

        swap(arr, l, j);

        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){

        System.out.println(new Test39().getOverHalf(new int[]{3,2,2}));

    }

}
