public class Test58 {

   public String Solution(String str){
       if (str.trim().equals(" ")){
           return " ";
       }

       String[] res = str.split(" ");
       StringBuffer stringBuffer = new StringBuffer();
       for (int i = res.length -1 ; i>=0;i--){
           stringBuffer.append(res[i]);
           stringBuffer.append(" ");

       }

       return stringBuffer.toString();


   }


   //先翻转整个字符串，再翻转每个单词，不用使用新的内存空间
    public String Solution2(String str){
       if (str == null)
           return null;


       char[] chars = str.toCharArray();
       reverse(chars,0,chars.length-1);
       int blank = -1;
       for (int i = 0 ; i < chars.length ;i ++){
           if (chars[i] == ' '){
               reverse(chars,blank+1,i-1);
               blank = i-1;
           }

       }
       reverse(chars,blank+1,chars.length-1);



       return new String(chars) ;


    }


    public void reverse(char[] chars , int i , int j){
       while ( i < j){
           char temp = chars[i];
           chars[i] = chars[j];
           chars[j] = temp;
           i++;
           j--;


       }


    }

    public String Solution3(String str ,int i){
       if (str == null)
           return null;

       char[] chars = str.toCharArray();
       int length = chars.length;
       if (i > 0 && i < length-1)

       reverse(chars,0,i-1);
       reverse(chars,i,length-1);
       reverse(chars,0,length-1);
       return new String(chars);

    }

   public static void main(String[] args){
//       System.out.print(new Test58().Solution("i am a student."));
//       System.out.println(new Test58().Solution2("i am a student. "));
//       System.out.println(new Test58().Solution2("student. "));
//       System.out.print(new Test58().Solution2("      "));
       System.out.print(new Test58().Solution3("abcdefg",2));
   }


}
