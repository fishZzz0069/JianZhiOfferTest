package Improved;

public class Solution19 {


    public boolean match(char[] str, char[] pattern)
    {

        if (str == null || pattern == null)
            return false;



        return matchCore(str,pattern,0,0);

    }

    private boolean matchCore(char[] str, char[] pattern,int strIndex,int patternIndex) {

        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }

        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }



        if ( patternIndex+1 < pattern.length && pattern[patternIndex+1]=='*'){
            if ((strIndex != str.length && str[strIndex] == pattern[patternIndex]) || (pattern[patternIndex] == '.'&& strIndex != str.length)){


                return matchCore(str,pattern,strIndex+1,patternIndex+2) ||
                        matchCore(str,pattern,strIndex+1,patternIndex) || matchCore(str,pattern,strIndex,patternIndex+2);


            }else {
                return matchCore(str,pattern,strIndex,patternIndex+2);
            }
        }




        if ((pattern[patternIndex] == '.' && strIndex != str.length) || (strIndex != str.length && pattern[patternIndex] == str[strIndex])){

            if ((strIndex!=str.length && str[strIndex] == pattern[patternIndex]) || (strIndex!=str.length && (pattern[patternIndex] == '.'))){
                return matchCore(str,pattern,strIndex+1,patternIndex+1);
            }

        }

        return false;



    }

    public static void main(String[] args){


        System.out.print(new Solution19().match(new char[]{},new char[]{'.','*'}));
    }
}
