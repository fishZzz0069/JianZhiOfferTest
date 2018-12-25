import java.util.HashMap;

public class Test50 {


    public Character getFirstOne(String string){

        if (string == null)
            return null;

        char[] chars = string.toCharArray();
        HashMap<Character,Integer> hashmap = new HashMap<>();

        for (int i = 0 ; i < chars.length ; i++){
            if (!hashmap.containsKey(chars[i])){
                hashmap.put(chars[i],1);
            }else {
                hashmap.put(chars[i],hashmap.get(chars[i]) + 1);

            }
        }

        Character res = null;
        for (int j = 0 ;j < chars.length ;j++){
            if (hashmap.get(chars[j]) == 1){
                return res = chars[j];
            }

        }

        return res;


    }

    public static void main(String[] args){
        System.out.println(new Test50().getFirstOne("ssadf"));
        System.out.println(new Test50().getFirstOne("sadf"));
        System.out.println(new Test50().getFirstOne(""));
        System.out.println(new Test50().getFirstOne("ssaaddff"));

    }
}
