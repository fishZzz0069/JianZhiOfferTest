import java.util.Stack;

public class Test30 {

     static class stackt {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackMin = new Stack<>();

        private void push(int num){
            stack.push(num);
            if (stackMin.isEmpty()){
                stackMin.push(num);
            }else if (stackMin.peek()< num){
                stackMin.push(stackMin.peek());
            }else {
                stackMin.push(num);
            }
        }

        private int pop(){
            stackMin.pop();
           int res = stack.pop();
           return res;
        }

        private int min(){
            int res = stackMin.pop();
            stack.pop();
            return res;
        }


    }

    public static void main(String[] args){
        stackt stackt = new stackt();
        stackt.push(1);
        stackt.push(2);
        stackt.push(0);
        stackt.push(4);
        System.out.println(stackt.min());
    }
}
