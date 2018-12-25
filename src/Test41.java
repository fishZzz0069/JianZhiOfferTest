import java.util.Comparator;
import java.util.PriorityQueue;

public class Test41 {



    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num){
          if (count % 2 == 0 ){
              //当数据总数为偶数时
              maxHeap.offer(num);
              int filteredNum = maxHeap.poll();
              minHeap.offer(filteredNum);
          }else{
              //当数据总数为奇数时
              minHeap.offer(num);
              int filteredNum = minHeap.poll();
              maxHeap.offer(filteredNum);
          }
          count++;
    }

    public Double getMiddle(){



        if (count %2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }





    }

    public static void main(String[] args){

        Test41 test41 = new Test41();
        test41.Insert(1);
        test41.Insert(2);
        test41.Insert(3);
        test41.Insert(4);
        System.out.println(test41.getMiddle());





    }


}
