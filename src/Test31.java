import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Stack;

public class Test31 {
    /*
    栈的压入弹出序列
    */

    public boolean stackHasSequence(int[] stackIn , int[] stackOut){
        if (stackIn.length != stackOut.length){
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int i = 0 ; i< stackIn.length ; i++){
            stack.push(stackIn[i]);
            while (!stack.isEmpty() && stackOut[j] == stack.peek()){
                stack.pop();
                j++;
            }

        }

        return stack.isEmpty();


    }


    public static void main(String[] args){
        int[] stackin = new int[]{1,2,3,4,5};
        int[] stackout = new int[]{5,4,3,2,1};
        System.out.println(new Test31().stackHasSequence(stackin,stackout));
    }

}
