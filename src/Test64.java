public class Test64 {

    public int getNSumWithout(int n){
        int sum = n;
        boolean ans = (n>0)&&((sum+=getNSumWithout(n-1))>0);
        return sum;
    }


    public static void main(String[] args){
        System.out.println(new Test64().getNSumWithout(100));
    }
}
