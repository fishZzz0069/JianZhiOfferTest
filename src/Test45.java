import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test45 {

    public String getMin(int[] num){
        List<Integer> res = new ArrayList<>();


        String s = "" ;

        for (int i = 0 ; i < num.length ; i++){
            res.add(num[i]);
        }

        Collections.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                System.out.println(" s1: " + s1 + " s2 " + s2 + " result: " + s1.compareTo(s2) );
                return s1.compareTo(s2);
            }
        });


        for(int j:res){
            s+=j;
        }

        return s;


    }

    public static void main(String[] args){

        System.out.println(new Test45().getMin(new int[]{1,44,11,332,101}));


    }
}
