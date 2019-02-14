package Improved;

public class Solution5 {

    public String replaceSpace(StringBuffer str){

        int length = str.length();
        int countBlank = 0;
        for (int i = 0 ; i < length ; i++){
            if (str.charAt(i) == ' '){
                countBlank++;
            }
        }
        int newLength = length + countBlank*2;
        char[] res = new char[newLength];
        int p1 = length-1;
        int p2 =  newLength-1;
        for (int i = p1 ; i >=0 ; i--){
            if (str.charAt(p1)!=' '){
                res[p2] = str.charAt(p1);
                p2--;
            }else {
                res[p2] = '0';
                res[p2-1] = '2';
                res[p2-2] = '%';
                p2 = p2-3;
            }

            p1--;


        }


        return new String (res);

    }

    public static void main(String[] args){
        StringBuffer stringBuffer = new StringBuffer("we are happy.");
        System.out.println(new Solution5().replaceSpace(stringBuffer));
    }

}
