import java.util.ArrayList;
import java.util.List;

public class Test38 {


    public String getAllCollection(String str,  String res){

        int n = str.length();


        for (int i = 0 ; i < n ; i++){
            if (i == n-1) {
                res = res + String.valueOf(str.charAt(i));
                res.substring(0,i);
            }else {
                for (int j = i ; j < n ; j++) {
                    swap(str.toCharArray(),i,j);
                    res = res + String.valueOf(str.charAt(j)) ;
                    getAllCollection(str.substring(j+1,n),res);
                    swap(str.toCharArray(),i,j);

                }

            }


        }
        return res;




    }


    public ArrayList<String> getResList(String str) {

        List<String> resultList = new ArrayList<>();
        if(str.length() == 0)
            return (ArrayList)resultList;
        //递归的初始值为（str数组，空的list，初始下标0）
        getCollectionsHelper(str.toCharArray(),0,resultList);

        return (ArrayList)resultList;
    }

    public ArrayList<String> getCollectionsHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {

            list.add(new String(cs));
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                getCollectionsHelper(cs, i + 1, list);
                swap(cs, i, j);
            }
        }

        return (ArrayList<String>) list;


    }

    public void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;



    }

    public static void main(String[] args){
        System.out.print(new Test38().getResList("abc").get(0));

    }
}
