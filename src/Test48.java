import org.omg.CORBA.PUBLIC_MEMBER;

public class Test48 {


    public int getLongestSubString(String string){


        char[] chars = string.toCharArray();
        int n = chars.length;
        if (n==0)
            return 0;
        int[] f = new int[n];
        int[] positions = new int[26];
        for (int k = 0 ; k < 26 ; k++){
            positions[k] = -1;
        }
        for (int i = 0 ; i < n ; i++){
            int m = (int)chars[i]-'a';
            if (positions[m] == -1){
                positions[m] = i;
                if (i == 0 ){
                    f[i] = 1;
                }else {
                f[i] = f[i-1] + 1;
                }
            }else {
                // already have the character
                int d = i - positions[m];
                if (d <= f[i-1]){
                    f[i] = d;
                    positions[m] = i; //注意维护下一次判断是相同字符的位置跟新，可能一个字符会重复多次出现
                }else {
                    f[i] = f[i-1]+1;
                }

            }



        }
        return f[n-1];


    }

    public static void main(String[] args){

        System.out.println(new Test48().getLongestSubString("aaaaaa"));
        System.out.println(new Test48().getLongestSubString("arabcacfr"));
        System.out.println(new Test48().getLongestSubString("a"));
        System.out.println(new Test48().getLongestSubString("abcedf"));
        System.out.println(new Test48().getLongestSubString(""));
    }
}
