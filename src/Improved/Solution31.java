package Improved;

import java.util.Stack;

public class Solution31 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        if (pushA.length!=popA.length){
            return false;
        }
        int n = pushA.length;

        Stack<Integer> stack = new Stack<>();
        int j = 0 ;
        for (int i =0 ; i < n ;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }

        }
        return stack.isEmpty();





    }
}
