import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Test17 {
    /**
     大数问题 可以考虑用字符串来解决
     */

    //打印1到最大的n位数
    public void printToMaxOfDigits(int n){
        if (n < 0 ){
            System.out.print("your input is meaningless");
        }

        char[] number = new char[n];

        for (int i = 0 ; i < number.length ; i++){
            number[i] = '0';
        }

        while (!increment(number)){
            printNumber(number);
            System.out.println();
        }

    }

    private void printNumber(char[] number) {
        boolean isBegin = false;
        for (int i = 0 ; i < number.length ; i++){
            if ( !isBegin && number[i] != '0'){
                isBegin = true;
            }
            if (isBegin){
                System.out.print(number[i]);
            }


        }
    }


    //自加


    private static boolean increment(char [] num){
        boolean isEnd = false;
        int len = num.length;
        int nTakeOver = 0;//进位
        for (int i = len - 1; i >= 0 ; i--) {
            int nSum = num[i] - '0' + nTakeOver;//当前值
            //只有是个位时，数值加1
            if(i == len - 1)
                nSum++;
            //满10进1
            if (nSum > 9){
                if(i == 0){
                    //超过n位
                    isEnd = true;
                }else {
                    nTakeOver = 1;
                    num[i] = '0';
                }
            }else {
                num[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isEnd;
    }



    //打印数字


    /**
     *
     * 递归
     */

    public void printMaxN( int n){

        if (n < 0 ){
            System.out.print("your input is meaningless");
        }

        char[] number = new char[n];

        for (int i = 0 ; i < number.length ; i++){
            number[i] = '0';
        }

        for (int i = 0 ; i < 10 ; i ++){
            number[0] = (char)(i + '0');
            printMaxNRecursive(number,0,n);
        }
        //index代表循环个十百位数，0是n位数最大的位数，循环完毕就得到最大数可以退出该递归了


    }

    public void printMaxNRecursive(char[] number , int index , int length){

        if (index == length -1){
            printNumber(number);
            System.out.println();
            return;
        }

        for (int i = 0 ; i< 10 ; ++i){
            number[index+1] = (char)(i + '0');
            printMaxNRecursive(number,index+1,length);
        }
    }


        public static void main(String[] args){

             new Test17().printMaxN(3);
        }
}
