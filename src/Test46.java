import java.util.ArrayList;
import java.util.List;

public class Test46 {
    private String letterMap[] = {
            "a",  //0
            "b",  //1
            "c",  //2
            "d",  //3
            "e",  //4
            "f",  //5
            "g",  //6
            "h",  //7
            "i",  //8
            "j",  //9
            "k",  //10
            "l",  //11
            "m",  //12
            "n",  //13
            "o",  //14
            "p",  //15
            "q",  //16
            "r",  //17
            "s",  //18
            "t",  //19
            "u",  //20
            "v",  //21
            "w",  //22
            "x",  //23
            "y",  //24
            "z"   //25
    };

    int res;
    public int getTranslateWays(int num){
        assert num>0;

        String numS =  String.valueOf(num);
        List<String> reslists = new ArrayList<>();




        String res = null;

        return Integer.valueOf(getwaysHelper(numS,reslists,res));


    }

    //回溯思想最后返回的条件确定不了！
    private String getwaysHelper(String numS,List<String> res,String resS) {



        if (numS.equals(""))
        {
            if (!res.contains(resS)){
                res.add(resS);
                res = null;
            }
        }




        if (numS.toCharArray().length >= 2){
            resS = letterMap[Integer.valueOf(numS.substring(0,1))] + getwaysHelper(numS.substring(1,numS.length()),res,resS) ;
            resS = letterMap[Integer.valueOf(numS.substring(0,2))] + getwaysHelper(numS.substring(2,numS.length()),res,resS) ;
        }else if (numS.toCharArray().length ==1){
            resS = letterMap[Integer.valueOf(numS.substring(0,1))] + getwaysHelper(numS.substring(1,numS.length()),res,resS) ;
        }

        return String.valueOf(res.size());
    }


    public int getStringNum(int[] nums){

        if (nums.length == 0 )
            return 0;

        int count;
        int[] f = new  int[nums.length];
        for (int i = nums.length - 1 ; i>=0 ;i--){
            count = 0;
            if(i<nums.length-1){
                count = f[i + 1];
            }else {
                count = 1;
            }


            if (i< nums.length-1){
                String dit = nums[i] + "" ;
                String dit2 = nums[i+1] +"" ;
                int temp = Integer.valueOf(dit+dit2);
                if (temp>=0 && temp <=25) {
                    if (i<nums.length - 2){
                        count += f[i+2];
                    }else {
                        count += 1;
                    }

                }


            }

            f[i] = count;

        }

        count = f[0];
        return count;


    }

    public static void main(String[] args){

        System.out.println(new Test46().getStringNum(new int[]{1,2,2,5,8}));
        System.out.println(new Test46().getStringNum(new int[]{1,2,2,6,8}));
    }

}
