import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Test16 {

    public double power(double base , int exponent){
        double result = 1;

        for (int i = 1 ; i < Math.abs(exponent) ; i++){
            result = result * base;
        }

        if (exponent<0){
            result  = 1/result;
        }
        return result;



    }


    public double improvedPower(double base , int exponent){



        if (exponent == 0 && base!=0)
            return 1;
        if (exponent == 1)
            return base;
        if (base == 0 && exponent <=0)
            throw new RuntimeException();
        if (base == 0 && exponent >0)
            return 0;

        int n = exponent;
        if (exponent < 0 ){
            n = -exponent;
        }

        double result = improvedPower(base,n>>1);
        result*= result;
        //如果是奇数，再多乘一个base值
        if ((n&1) == 1)
            result *= base;

        if(exponent<0)
            result=1/result;
        return result;
    }

    public static void main(String[] args){
        System.out.print(new Test16().improvedPower(2.0,5));


    }


}
