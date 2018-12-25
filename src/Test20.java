public class Test20 {
    public boolean strIsNumber(String str){
        boolean hasE = false ;
        boolean hasPoint = false;
        boolean hasF = false;
        for (int i = 0 ; i < str.length() ; i ++){




            if (str.charAt(i) == 'e' || str.charAt(i) == 'E')
            {
                if (hasE || i ==str.length()-1){
                return false;
                }

                hasE = true;

            }else if (str.charAt(i) == '+' || str.charAt(i) == '-')
            {
                //第一次出现时
                if (!hasF && i!=0 && str.charAt(i-1) != 'e' && str.charAt(i-1) != 'E'){
                    return false;
                }
                //正负号第二次出现时前方必须为e或者E
                if (hasF && str.charAt(i-1)!='e' && str.charAt(i-1)!='E')
                {
                    return false;
                }

                hasF = true;

            }else if (str.charAt(i) == '.')
            {
                if (hasE || hasPoint){
                    return false;
                }
                hasPoint = true;

            }else if (str.charAt(i) < '0' || str.charAt(i)>'9')
            {
                return false;
            }


        }

        return true;

    }


    public static void main(String[] args){
        System.out.println(new Test20().strIsNumber("-1E-16"));
    }
}
