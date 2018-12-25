public class Test43 {

    public int get1s(int n){

        int res = 0 ;

        int i = 1;
        int current = 0 , after = 0 ,before = 0;

        while ((n/i)!=0){
            current = (n/i)%10;
            before = n/(i*10);
            after = n-(n/i)*i;

            if (current == 0 ){
                res += before*i;
            }else if (current == 1){
                res += before*i + after + 1;
            }else {
                res += (before + 1) * i;
            }
            i *= 10;


        }

        return res;

    }

    public static void main(String[] args){
        System.out.println(new Test43().get1s(1));
    }
}
