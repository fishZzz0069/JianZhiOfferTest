public class Test15 {

    /**
     如果是一个负数，最高位移动位置后，仍然要保证最高位为1，此时会造成死循环
     0x（代表16进制）FFFFFFFF
     */
    public int getCountOne(int n){

        int count = 0 ;
        while(n>0){
            if(( n & 1 ) == 1){
                count++;
            }
            n = n >> 1;

        }

        return count;


    }

    public int getCountOne2(int n){

        int count = 0 ;
        int flag = 1;
        while(flag != 0 ){
            if(( flag & n ) != 0){
                count++;
            }
            flag = flag << 1;

        }
         /**
         flag = 0000 0001
          依次向左移 判断n该位是否为1 维护count
          将唯一的1移除二进制 即变为00000000 此时循环结束 1的位数也统计出来 并且不会造成死循环也不会将1的符号为考虑进去 在01000000 的下一步时 已经退出。
        */
        return count;


    }


    public static int NumberOf1(int n) {
        /**

        每次进while操作时，都会将最右边的1转换成0 直至全部为0 无法进去
         （进入while循环依次即少一个1 因此每次进入循环进行count维护即可得出该二进制中有多少个1）
         */

        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }


    public static void main(String[] args){
        System.out.print(new Test15().NumberOf1(-10));


    }




}
