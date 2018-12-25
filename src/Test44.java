public class Test44 {

    public int getNnumer(int n){

        int res ;


        if (n < 10){
          return res = n;
        }

        int leftNum = n - 10;
        int i = 1;
        while (leftNum >= 0){

            i++;
            if ((leftNum-9*Math.pow(10,i-1)*i)<=0){
                break;
            }else {
                leftNum -= 9*Math.pow(10,i-1)*i;
            }


        }

        int t1 = (int) (Math.pow(10,i-1) + leftNum/i);
        int t2 = leftNum%i;

        res  = String.valueOf(t1).charAt(t2) - '0';


        return res;


    }

    public static void main(String[] args){

        System.out.println(new Test44().getNnumer(1001));
        System.out.println(new Test44().getNnumer(13));
        System.out.println(new Test44().getNnumer(10));
        System.out.println(new Test44().getNnumer(5));
        System.out.println(new Test44().getNnumer(0));
        System.out.println(new Test44().getNnumer(1));
    }
}
