package Improved;

public class Solution10 {

    /*
    * 最基础的斐波那契数列解法
    * 从上往下递归实现
    * 重复计算过多导致效率低
    *
    * */
    public int Fibonacci(int n) {

        if(n == 1){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    /*
     * 记忆画搜索将已经算过的值保存下来
     * 提高效率
     *
     * */
    public int Fibonacci2(int n){

        if(n<=1){
            return n;
        }
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2 ; i <= n ; i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }

}
