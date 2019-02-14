public class Test65 {
    public int addWithout(int num1,int num2){


        while( num2!=0 ){
            int sum = num1 ^ num2;
            int carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        }
        return num1;




    }

    public static void main(String[] args){
  //      System.out.println(new Test65().addWithout(2,3));
//        System.out.println(new Test65().addWithout(2,-3));
//        System.out.println(new Test65().addWithout(0,3));
        System.out.println(new Test65().addWithout(111,899));


    }
}
