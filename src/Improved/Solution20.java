package Improved;

public class Solution20 {

    public boolean isNumeric(char[] str) {

        boolean hasE = false ;
        boolean hasPoint = false;
        boolean hasF = false;
        for (int i = 0 ; i < str.length ; i ++){




            if (str[i] == 'e' || str[i] == 'E')
            {
                //只能出现一次并且不能出现在最后一个位置
                if (hasE || i ==str.length-1){
                    return false;
                }

                hasE = true;

            }else if (str[i] == '+' || str[i] == '-')
            {
                //第一次出现时，必须出现在第一个位置或者e/E之后
                if (!hasF && i!=0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
                //正负号第二次出现时前方必须为e或者E
                if (hasF && str[i-1]!='e' && str[i-1]!='E')
                {
                    return false;
                }

                hasF = true;

            }
            //有点的限制条件是不能出现在E／e的后面或者出现两次
            else if (str[i] == '.')
            {
                if (hasE || hasPoint){
                    return false;
                }
                hasPoint = true;

            }else if (str[i] < '0' || str[i]>'9')
            {
                return false;
            }


        }

        return true;

    }


    public static void main(String args[]){

        char[] test = new char[4];
        String string = "123.";
        for (int i = 0 ; i < string.length() ; i++){
            test[i] = string.charAt(i);
        }
        System.out.print(new Solution20().isNumeric(test));
    }





}
