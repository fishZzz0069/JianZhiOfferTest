public class Test4 {

    public String replaceBlank(String str){

        int blankNumber = 0;
        int n = str.length();
        for (int i = 0; i < str.length() ; i++){
            if (str.charAt(i) == ' '){
                blankNumber++;
            }
        }

        int addedSpace = n + 2*blankNumber;
        char[] res = new char[addedSpace];

        
        int p2 = addedSpace-1;
        int p1 = n-1;
        while (p2 != p1 ||  p1 >= 0){

            if (str.charAt(p1) == ' '){
                res[p2] = '0';
                res[p2-1] = '2';
                res[p2-2] = '%';
                p2 = p2-3;
                p1--;
            }else {
                res[p2] = str.charAt(p1);
                p1--;
                p2--;
            }


        }
        String resS = new String(res);


        return resS;
    }

    public static void main (String[] args){
       String res =  new Test4().replaceBlank("we arr happy.");

       System.out.print(res.toString());



    }
}
