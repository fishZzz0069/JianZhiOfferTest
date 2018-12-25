import java.util.Stack;

public class Test9 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public Integer appendTail(Integer num){
        stack1.push(num);
        return num;
    }

    public Integer deleteHead(){

        if (stack2.isEmpty()){

             while (!stack1.isEmpty()){
                 stack2.push(stack1.pop());
             }

        }





        return  stack2.pop();

    }


    public static void main(String[] args){
        Test9 queue = new Test9();


        queue.appendTail(5);
        queue.appendTail(4);

        System.out.print(queue.deleteHead());
    }


}
