import java.util.ArrayDeque;
import java.util.ArrayList;

public class Test59 {


    public ArrayList<Integer> maxInWindows(int[] nums , int size){
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) return res;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0 ; i < nums.length ; i++){
            int begin = i- size + 1;
            if (queue.isEmpty()){
                queue.add(i);
            }else if (queue.peekFirst() < begin){
                queue.pollFirst();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.removeLast();
            }
            queue.add(i);

            if (begin>=0)
                res.add(nums[queue.peekFirst()]);

        }

        return res;


    }




    public static void main(String[] args){
//        System.out.println(new Test59().maxInWindows(new int[]{2,3,4,2,6,2,5,1},3));
        Myqueue<Integer> queue = new Myqueue<>();
        queue.push_back(3);
        System.out.println(queue.max());
        queue.push_back(5);
        System.out.println(queue.max());
        queue.push_back(1);
        System.out.println(queue.max());
        System.out.println("开始出队后，调用max");
        System.out.println(queue.max());
        queue.pop_front();
        System.out.println(queue.max());
        queue.pop_front();
        System.out.println(queue.max());
        queue.pop_front();
        System.out.println(queue.max());

    }


    public static class Myqueue<T extends Comparable>{


        private static class InternalData<M extends Comparable> {
            public M value;
            public int index;
            public InternalData(M value,int index){
                this.value = value;
                this.index = index;
            }
        }
        private ArrayDeque<InternalData> queueData;
        private ArrayDeque<InternalData> maxQueue;
        private int currenetIndex;
        public Myqueue(){
            this.queueData = new ArrayDeque<>();
            this.maxQueue = new ArrayDeque<>();
            this.currenetIndex = 0;

        }

        public Comparable max(){

            if (!maxQueue.isEmpty()){
                return maxQueue.peekFirst().value;
            }else
                return null;
        }

        public void push_back(Integer num){
            InternalData dataAdded = new InternalData(num,currenetIndex);
            queueData.addLast(dataAdded);
            while (!maxQueue.isEmpty() && num.compareTo((Integer) maxQueue.peekLast().value)>=0){
                maxQueue.removeLast();
            }
            maxQueue.addLast(dataAdded);
            currenetIndex++;
        }

        public void pop_front(){
            if (queueData.isEmpty()){
                return;
            }
            InternalData popedData = queueData.removeFirst();
            if (popedData.index == maxQueue.getFirst().index){
                maxQueue.removeFirst();
            }



        }

    }

}
