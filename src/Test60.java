public class Test60 {


    public static int MAX = 6;
    public void printSolutionPosibility(int n){
        if (n < 1)
            return;
        double total = Math.pow(6,n);
        int len = n*MAX - n*1 +1;//可能出现的情况是从N*1到N*6的
        int[] times = new int[len];
        for (int i =1;i <=MAX ; i++){ // initial the first dice
            probabilityOfDice(n,i,n, 0,times);
        }

        for(int i=0;i<len;i++){
            System.out.println((i+n)+","+times[i]+"/"+total);
        }

    }

    private void probabilityOfDice(int n,int curDiceValue,int numOfDices,int curSum,int[] times){

        if (numOfDices == 1){
            int sum = curSum + curDiceValue;
            times[sum-n]++;
        }else {
            int sum = curSum + curDiceValue;
            for (int i = 1 ; i <=MAX ; i++){
                probabilityOfDice(n,i,numOfDices-1,sum,times);
            }
        }


    }

    public void printSolutionPosibility2(int n){

        if (n<1){
            return;
        }

        double total = Math.pow(MAX,n);
        int maxSum = n*MAX;
        double[][] f = new double[n+1][n*MAX+1];
        for (int i = 1 ;i <MAX ; i++){
            //initial the state
            f[1][i] = 1;
        }

        for (int k =2 ; k<=n ; k++){

            for (int sum = n ; sum < maxSum ; sum++){
                for (int i = 1 ; sum-i >=1 &&i <=MAX ; i++ ){
                    f[k][sum] += f[k-1][sum-i];
                }
            }


        }

        for(int sum=n;sum<=maxSum;sum++){
            System.out.println(sum+","+f[n][sum]+"/"+total);
        }


    }
    public static void main(String[] args){
        new Test60().printSolutionPosibility2(2);
    }
}
