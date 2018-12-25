import java.util.Stack;

public class Test49 {

    public int getUgluNumbersByIndex(int index){

        if (index<=0){
            return -1;
        }
        int[] array = new int[index];
        array[0] = 1;
        int p2 = 0;
        int p3 = p2 ;
        int p5 = p2 ;

        for (int i = 1 ; i < index ; i++){
            array[i] = Math.min((array[p5] *5) ,Math.min(array[p2] * 2,array[p3] *3));
            if (array[p5] * 5 == array[i])
                p5++;
            if (array[p2] * 2 == array[i])
                p2++;
            if (array[p3] * 3 == array[i])
                p3++;

        }

        return array[index-1];




    }

    public static void main(String[] args){
        System.out.println(new Test49().getUgluNumbersByIndex(2));
        System.out.println(new Test49().getUgluNumbersByIndex(3));
        System.out.println(new Test49().getUgluNumbersByIndex(4));
        System.out.println(new Test49().getUgluNumbersByIndex(1500));
        System.out.println(new Test49().getUgluNumbersByIndex(1));
        System.out.println(new Test49().getUgluNumbersByIndex(0));
    }
}
