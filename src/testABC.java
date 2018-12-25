import com.sun.tools.javac.comp.Lower;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

public class testABC {







    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mNumber = in.nextInt();
        IdentityHashMap<String,String> hashMap= new IdentityHashMap<>();
        for (int i = 0 ; i < mNumber ; i++){
            String cost = in.next();
            String mentals = in.next();
            hashMap.put(cost,mentals);
        }

        Set<String> costLists = hashMap.keySet();
        List<String> costs = new ArrayList<>(hashMap.keySet());
        Collections.sort(costs);
        int costTotal = 0;
        String values = "";
        String value = "";
        for (int i = 0 ;i < mNumber ;i++){
            //System.out.println("cost:"+ costs.get(i) + "value:" + hashMap.get(costs.get(i)));



                value = hashMap.get(costs.get(i));

                if ((value.contains("a") && !values.contains("a")) || (values.contains("b") &&!values.contains("b"))
                        || (value.contains("c") && !values.contains("c"))) {
                    values = values + value;
                    costTotal = Integer.valueOf(costs.get(i)) + costTotal;

                }
                if (values.contains("a")&&values.contains("b")&&values.contains("c")) {
                  System.out.println("costTotal:" + costTotal + "values:" + values);
                }else if ( i == mNumber -1 && !values.contains("abc")){
                    System.out.println("-1");
                }
        }




    }
}
