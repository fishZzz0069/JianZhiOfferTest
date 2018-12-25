public class Test21 {


    public void oddBeFirst(int[] arr){
        int p1 = 0 ;
        int p2 = arr.length-1;

        while (p1<p2){

            if (arr[p1]%2 ==0){
                p1++;
            }
            if (arr[p2]%2 ==1){
                p2--;
            }
            if (p1<p2 ){
                int temp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = temp;
            }

        }

        for (int i = 0 ; i <arr.length ; i++){
            System.out.println(arr[i]);
        }


    }

    public static void main(String[] args){
        int[] arr = new  int[]{3,1,2,4};
       new Test21().oddBeFirst(arr);
    }
}
